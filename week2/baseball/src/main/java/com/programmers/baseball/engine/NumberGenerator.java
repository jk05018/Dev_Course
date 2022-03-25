package com.programmers.baseball.engine;

import java.util.stream.Stream;

import com.github.javafaker.Faker;
import com.programmers.baseball.engine.model.Numbers;

// faker를 통해서 GEenrate 가능
// 게임 엔진은 어떤 디펜던시도 안가져가는ㄴ 게 낫다
public interface NumberGenerator {
		Numbers generate(int count);
}
