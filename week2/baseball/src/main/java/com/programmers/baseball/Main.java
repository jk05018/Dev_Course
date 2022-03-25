package com.programmers.baseball;

import java.util.Arrays;
import java.util.stream.Stream;

import com.github.javafaker.Faker;

public class Main {
	public static void main(String[] args) {
		Faker faker = new Faker();

		// randomDigitNotzero -> 0을 제외한 1 ~ 9 숫자
		// 중복되지 않는 숫자 뽑기!
		Integer[] nums = Stream.generate(() -> faker.number().randomDigitNotZero())
			.distinct()
			.limit(10)
			.toArray(Integer[]::new);

		System.out.println(Arrays.toString(nums));
	}
}
