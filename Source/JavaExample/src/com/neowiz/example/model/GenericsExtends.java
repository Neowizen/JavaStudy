package com.neowiz.example.model;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 25. 오후 1:53:28
 */
public class GenericsExtends<T extends DataBase> {
	
	public void printSeq(T t) {
		System.out.println(t.getSeq());
	}
	
}
