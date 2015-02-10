package com.neowiz.example.model;

import java.util.Map;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.Ordering;
import com.google.common.primitives.Ints;

public class Bakery extends DTO {
	private BakeryType type;
	private String name;
	private Integer saleCnt;
	
	public Bakery(BakeryType type, String name) {
		this.type = type;
		this.name = name;
		this.saleCnt = 0;
	}
	
	public Bakery(BakeryType type, String name, Integer saleCnt) {
		this.type = type;
		this.name = name;
		this.saleCnt = saleCnt;
	}
	
	public static final Ordering<Bakery> NAME_ORDERING = new Ordering<Bakery>() {
		@Override
		public int compare(Bakery left, Bakery right) {
			return Ints.compare(left.getName().length(), right.getName().length());
		}
	};
	
	public static final Ordering<Bakery> SALE_CNT_ORDERING = new Ordering<Bakery>() {
		@Override
		public int compare(Bakery left, Bakery right) {
			return Ints.compare(left.getSaleCnt(), right.getSaleCnt());
		}
	};

	public static final Function<Bakery, BakeryType> TYPE_FILTER = new Function<Bakery, BakeryType>() {
		@Override
		public BakeryType apply(Bakery input) {
			return input.getType();
		}
	};
	
	public static final Function<Bakery, String> NAME_FILTER = new Function<Bakery, String>() {
		@Override
		public String apply(Bakery input) {
			return input.getName();
		}
	};
	
	public static final Function<Bakery, Integer> SALE_CNT_FILTER = new Function<Bakery, Integer>() {
		@Override
		public Integer apply(Bakery input) {
			return input.getSaleCnt();
		}
	};
	
	public static final Predicate<Bakery> TYPE_FINDER(final BakeryType type) {
		return new Predicate<Bakery>() {
			@Override
			public boolean apply(Bakery input) {
				if (null == input) {
					return false;
				}
				
				if (null == input.getType()) {
					return false;
				}
				
				return (type.equals(input.getType()));
			}
		};
	}
	
	public static final Predicate<Bakery> NAME_FINDER(final String name) {
		return new Predicate<Bakery>() {
			@Override
			public boolean apply(Bakery input) {
				if (null == input) {
					return false;
				}
				
				if (null == input.getName()) {
					return false;
				}
				
				return (name.equals(input.getName()));
			}
		};
	}
	
	public static final Predicate<Map.Entry<String, Bakery>> MAP_ENTRY_TYPE_FINDER(final BakeryType type) {
		return new Predicate<Map.Entry<String, Bakery>>() {
			@Override
			public boolean apply(Map.Entry<String, Bakery> input) {
				if (null == input) {
					return false;
				}
				
				if (null == input.getValue().getType()) {
					return false;
				}
				
				return (type.equals(input.getValue().getType()));
			}
		};
	}
	
	public BakeryType getType() {
		return type;
	}
	
	public void setType(BakeryType type) {
		this.type = type;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getSaleCnt() {
		return saleCnt;
	}
	
	public void setSaleCnt(Integer saleCnt) {
		this.saleCnt = saleCnt;
	}
}
