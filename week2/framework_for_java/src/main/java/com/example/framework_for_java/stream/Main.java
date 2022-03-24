package com.example.framework_for_java.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.Stream;

public class Main {
	public static void main(String[] args) {
		// List에서 Stream 만드는 방법
		Stream<Integer> s = Arrays.asList(1, 2, 3).stream();

		// Arrays에서 stream 만드는 방법
		// boxed를 사용하면 WRapper 클래스로 변환 가능하다/
		Arrays.stream(new int[]{1,2,3}).boxed().toArray(Integer[]::new);

		// 1이 계속 출력됨 : Stream의 데이터의 연속이기 때문에 끊임없이 만들어낸다
		// Stream.generate(() -> 1)
		// 	.forEach(System.out::println);

		// 난수값 만드는 방법
		Random r = new Random();
		Stream.generate(() -> r)
			.limit(10)
			.forEach(System.out::println);

		Stream.iterate(0,(i) -> i+1);
	}
}

