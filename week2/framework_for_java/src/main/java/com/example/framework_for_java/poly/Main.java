package com.example.framework_for_java.poly;

// java.lang.Runnable
// interface는 이렇게 생김?
interface MyRunnable{ // 모든 메서드가 추상 메서드로 이루어진
	void myRun();
}

interface YourRunnable{ // 모든 메서드가 추상 메서드로 이루어진
	void yourRun();
}

public class Main implements MyRunnable, YourRunnable{
	public static void main(String[] args) {
		// 인터페이스는 Runnable을 상속한다?
		// Runnable은 Run 기능밖에 없다.
		MyRunnable m = new Main();
		m.myRun();
	}

	@Override
	public void myRun() {
		System.out.println("my Run");
	}

	@Override
	public void yourRun() {

	}
}
