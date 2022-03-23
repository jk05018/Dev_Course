package com.example.framework_for_java.def;

// Default 메서드
// 인터페이스가 구현체를 가진다>???
interface  MyInterface{ // interface 원래 추상 메서드로 이루어진 메서드
	void method(); // 기본 public

	// default 메서드는 재정의하지 않아도 된다
	default void method2(){ // 구현 메서드
		System.out.println("method2");
	}
}

public class Main extends MyInterfaceAdapter{
	public static void main(String[] args) {
		new Main().method2();
	}
	@Override
	public void method() {

	}
}
