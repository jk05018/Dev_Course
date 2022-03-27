package com.programmers.baseball;

import com.programmers.baseball.engine.BaseBall;
import com.programmers.baseball.engine.model.NumberGenerator;

public class App {
	public static void main(String[] args) {

		NumberGenerator generator = new FakeNumberGenerator();
		Console console = new Console();

		new BaseBall(generator, console, console).run();
	}
}
