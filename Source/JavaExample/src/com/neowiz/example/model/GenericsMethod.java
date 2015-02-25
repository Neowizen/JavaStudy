package com.neowiz.example.model;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 25. 오후 1:49:48
 */
public class GenericsMethod {
	public String get() {
		return "TEST";
	}
	
	public <T> String getClassName(T t) {
		return t.getClass().getName();
	}
}
