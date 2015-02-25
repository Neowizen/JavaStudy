package com.neowiz.example.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 25. 오후 1:38:11
 */
public class GenericsBase<T> implements Generics<T> {
	private T t;

	public T get() {
		return t;
	}

	public void set(T t) {
		this.t = t;
	}

	@Override
	public List<T> toList() {
		List<T> list = new ArrayList<T>();
		list.add(this.get());
		
		return list;
	}

	@Override
	public Set<T> toSet() {
		Set<T> set = new HashSet<T>();
		set.add(this.get());
		
		return set;
	}
	
	public <U> void print(U u) {
		System.out.println("T: " + t.getClass().getName());
		System.out.println("U: " + u.getClass().getName());
	}
}
