package com.programmers.baseball.engine;

import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;

import com.programmers.baseball.engine.io.Input;
import com.programmers.baseball.engine.io.Output;
import com.programmers.baseball.engine.model.BallCount;
import com.programmers.baseball.engine.model.Numbers;

public class BaseBall implements Runnable {
	private final int COUNT_OF_NUMBERS = 3;

	private NumberGenerator generator;
	private Input input;
	private Output output;

	public BaseBall(NumberGenerator generator, Input input, Output output) {
		this.generator = generator;
		this.input = input;
		this.output = output;
	}

	@Override
	public void run() {
		Numbers answer = generator.generate(COUNT_OF_NUMBERS);

		while (true) {
			String inputString = input.input("숫자를 맞춰보세요. : ");
			Optional<Numbers> inputNumbers = parse(inputString); // 게임 엔진 내에서 해야할 작업
			if (inputNumbers.isEmpty()) {
				output.inputError();
				continue;
			}
			BallCount bc = ballCount(answer, inputNumbers.get());

			if (bc.getStrike() == 3) {
				output.correct();
				break;
			}
		}
	}

	private Optional<Numbers> parse(String inputString) {
		if (inputString.length() != COUNT_OF_NUMBERS)
			return Optional.empty();
		long count = inputString.chars()
			.filter(Character::isDigit)
			.map(Character::getNumericValue)
			.filter(i -> i > 0)
			.distinct()
			.count();
		if (count != COUNT_OF_NUMBERS)
			return Optional.empty();
		return Optional.of(
			new Numbers(
				inputString.chars()
					.map(Character::getNumericValue)
					.boxed()
					.toArray(Integer[]::new)));
	}

	private BallCount ballCount(Numbers answer, Numbers inputNumbers) {
		AtomicInteger strike = new AtomicInteger();
		AtomicInteger ball = new AtomicInteger();

		// 람다 내의 변수는 스코프 안에서만 동작한다?>
		// 예를들어 안의 strike 가 밖의 Strike에 영향을 주면 안되도록 권장ㅎ나다
		// 멀티 스레드 환경? -> 동기화 해줘야 한다?
		answer.indexForEach((a, i) -> {
			inputNumbers.indexForEach((n, j) -> {
				if (a.equals(n))
					return;
				if (i.equals(j))
					strike.addAndGet(1);
				else
					ball.addAndGet(1);

			});
		});
		return new BallCount(strike.get(), ball.get());
	}
}
