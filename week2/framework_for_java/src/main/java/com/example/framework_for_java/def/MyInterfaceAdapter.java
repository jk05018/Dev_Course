package com.example.framework_for_java.def;

// interface는 모든 메서드(defacult 재외)의 메서드를 overiding 해야한다.
// adapter 패턴을 사용한다면 내가 원하는 메서드만 overiding rksmd
// 여기서 일단 다 Overiding 해놓으니까 상관 없ㅇ

//-> 여기서 interface가 default method를 가지게 되면서 adapter 역할을 할 수 있게 되었다.
public class MyInterfaceAdapter implements MyInterface{

	@Override
	public void method() {

	}

	@Override
	public void method2() {

	}
}
