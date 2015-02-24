package com.neowiz.example.model;

import java.util.List;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;


/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 23. 오후 10:14:25
 */
public enum DAY implements EnumBase<DAY> {
	MONDAY(1) {
		@Override
		public boolean isHoliday() {
			return false;
		}
	},
	TUESDAY(2) {
		@Override
		public boolean isHoliday() {
			return false;
		}
	},
	WEDNESDAY(3) {
		@Override
		public boolean isHoliday() {
			return false;
		}
	},
	THURSDAY(4) {
		@Override
		public boolean isHoliday() {
			return false;
		}
	},
	FRIDAY(5) {
		@Override
		public boolean isHoliday() {
			return false;
		}
	},
	SATURDAY(6) {
		@Override
		public boolean isHoliday() {
			return true;
		}
	},
	SUNDAY(7) {
		@Override
		public boolean isHoliday() {
			return true;
		}
		
		@Override
		public DAY prev() {
			return DAY.SUNDAY;
		}
		
		@Override
		public DAY next() {
			return DAY.SUNDAY;
		}
	};
	
	private final int data;
	
	private DAY(int data) {
		this.data = data;
	}

	public int getData() {
		return data;
	}

	public abstract boolean isHoliday();
	
	public static boolean holiday(DAY day) {
		switch (day) {
			case SATURDAY:
			case SUNDAY:
				return true;
	
			default:
				return false;
		}
	}
	
	public static Optional<DAY> find(String name) {
		return Enums.getIfPresent(DAY.class, Strings.nullToEmpty(name));
	}
	
	@Override
	public DAY prev() {
		List<DAY> dayList = Lists.newArrayList(DAY.values());
		int maxIndex = dayList.size() - 1;
		
		int index = this.ordinal() - 1;
		if (index < 0) {
			index = maxIndex;
		}
		
		return dayList.get(index);
	}
	
	@Override
	public DAY next() {
		List<DAY> dayList = Lists.newArrayList(DAY.values());
		int maxIndex = dayList.size() - 1;
		
		int index = this.ordinal() + 1;
		if (index > maxIndex) {
			index = 0;
		}
		
		return dayList.get(index);
	}
	
	//@Override
	//public String toString() {
	//	return this.name().toLowerCase();
	//}
}
