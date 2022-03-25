package com.programmers.baseball.engine.model;

import java.util.function.BiConsumer;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Numbers {
	private Integer[] nums;

	public void indexForEach(BiConsumer<Integer,Integer> consumer) {
		for(int i=0; i<nums.length ; ++i){
			consumer.accept(nums[i], i);
		}
	}
}
