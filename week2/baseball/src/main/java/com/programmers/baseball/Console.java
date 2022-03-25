package com.programmers.baseball;

import java.util.Scanner;

import com.programmers.baseball.engine.io.Input;
import com.programmers.baseball.engine.io.Output;
import com.programmers.baseball.engine.model.BallCount;

public class Console implements Input, Output {
	private final Scanner scanner = new Scanner(System.in);
	@Override
	public String input(String prompt) {
		System.out.println(prompt);
		return scanner.next();
	}

	@Override
	public void ballCount(BallCount bc) {
		System.out.println(bc.getStrike() + " Strikes," + bc.getBall() + " Balls");
	}

	@Override
	public void inputError() {
		System.out.println("입력이 잘못되었습니다!");
	}

	@Override
	public void correct() {
		System.out.println("정답입니다!");
	}
}
