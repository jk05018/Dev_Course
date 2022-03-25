package com.programmers.baseball.engine.io;

import com.programmers.baseball.engine.model.BallCount;

public interface Output {
	void ballCount(BallCount bc);
	void inputError();
	void correct();
}
