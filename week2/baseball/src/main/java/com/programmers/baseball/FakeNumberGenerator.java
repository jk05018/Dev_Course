package com.programmers.baseball;

import java.util.stream.Stream;

import com.github.javafaker.Faker;
import com.programmers.baseball.engine.NumberGenerator;
import com.programmers.baseball.engine.model.Numbers;

public class FakeNumberGenerator implements NumberGenerator {
	private final Faker faker = new Faker();

	@Override
	public Numbers generate(int count) {
		return new Numbers(
			Stream.generate(() -> faker.number().randomDigitNotZero())
				.limit(count)
				.toArray(Integer[]::new));
	}
}
