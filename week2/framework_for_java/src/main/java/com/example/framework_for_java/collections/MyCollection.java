package com.example.framework_for_java.collections;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import com.example.framework_for_java.iter.MyIterator;

public class MyCollection<T> {
	private List<T> list;

	public MyCollection(List<T> list) {
		this.list = list;
	}

	public MyCollection<T> filter(Predicate<T> predicate) {
		List<T> newList = new ArrayList<>();
		for (T d : list) {
			if (predicate.test(d))
				newList.add(d);
		}

		return new MyCollection<>(newList);

	}

	public <U> MyCollection<U> map(Function<T, U> function) {
		List<U> newList = new ArrayList<>();
		for (T item : list) {
			newList.add(function.apply(item));
		}
		return new MyCollection<>(newList);
	}

	public int count() {
		return list.size();
	}

	public void foreach(Consumer<T> consumer) {
		for (int i = 0; i < list.size(); ++i) {
			T data = list.get(i);
			consumer.accept(data);
		}
	}

	public MyIterator<T> iterator(){
		return new MyIterator<T>() {
			private int index;

			@Override
			public boolean hasNext() {
				return index < list.size();
			}

			@Override
			public T next() {
				return list.get(index++);
			}
		};
	}
}
