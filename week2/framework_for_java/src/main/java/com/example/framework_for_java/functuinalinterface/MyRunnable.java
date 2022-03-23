package com.example.framework_for_java.functuinalinterface;

@FunctionalInterface
public interface MyRunnable {
	void run(); // 추상 메서드가 하나밖에 없는 메서드 == 함수형 인터페이스
}

// 함수형 인터페이스에 2가지 이상의 추상 메서드를 선언할 수 없다.
/*@FunctionalInterface
interface  MyRunnable2{
	void run1();
	void run2();
}*/

// 함수형 인터페이스는 대신 default 메서드는 선언할 수 있다 왜?
@FunctionalInterface
interface MyMap {
	void map();

	default void myMap() {
		System.out.println("myMap");
	}
}
