package com.neowiz.example.model;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 23. 오후 10:14:39
 */
public enum MONTH {
	JANUARY(1),
	FEBRUARY(2),
	MARCH(3),
	APRIL(4),
	MAY(5),
	JUNE(6),
	JULY(7),
	AUGUST(8),
	SEPTEMBER(9),
	OCTOBER(10),
	NOVEMBER(11),
	DECEMBER(12);
	
	private final int data;
	
	private MONTH(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}
}
