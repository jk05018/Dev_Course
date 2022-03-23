package com.example.framework_for_java.functuinalinterface;

public class Main {
	public static void main(String[] args) {
		// 함수형 인터페이스를 선언하고 사용하는 방법
		new MySupply(){
			@Override
			public String supply() {
				return null;
			}
		};
	}
}
