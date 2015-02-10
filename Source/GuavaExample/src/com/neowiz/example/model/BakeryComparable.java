package com.neowiz.example.model;

public class BakeryComparable extends Bakery implements Comparable<BakeryComparable> {
	
	public BakeryComparable(BakeryType type, String name, Integer saleCnt) {
		super(type, name, saleCnt);
	}

	/**
	 * 두 값이 같으면 0, this가 크면 양수, this가 적으면 음수
	 */
	@Override
	public int compareTo(BakeryComparable o) {
		return this.getSaleCnt() - o.getSaleCnt();
	}
	
}
