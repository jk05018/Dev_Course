package com.example.framework_for_java.collections;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		int s = new MyCollection<String>(Arrays.asList("A", "CA", "DSD", "ASDC", "ASDFG"))
			.map(String::length)
			.filter(i -> i % 2 == 1)
			.count();

		System.out.println(s);
	}



}
