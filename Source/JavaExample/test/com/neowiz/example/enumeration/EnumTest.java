package com.neowiz.example.enumeration;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.base.Optional;
import com.neowiz.example.model.DAY;
import com.neowiz.example.model.MONTH;



/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 23. 오후 10:18:00
 */
public class EnumTest {

	@Test
	public void values() {
		DAY[] day = DAY.values();
		int actual = day.length;

		assertThat(actual).isEqualTo(7);
	}
	
	@Test
	public void valueOf() {
		DAY actual = DAY.valueOf("FRIDAY");
		
		assertThat(DAY.FRIDAY.equals(actual)).isTrue();
	}

	@Test
	public void equals() {
		boolean actual1 = DAY.MONDAY.equals(MONTH.JANUARY);
		assertThat(actual1).isFalse();
		
		DAY check = DAY.MONDAY;
		boolean actual2 = DAY.MONDAY.equals(check);
		assertThat(actual2).isTrue();
	}
	
	@Test
	public void compareTo() {
		int actual1 = DAY.MONDAY.compareTo(DAY.MONDAY);
		assertThat(actual1).isEqualTo(0);
		
		int actual2  = DAY.WEDNESDAY.compareTo(DAY.MONDAY);
		assertThat(actual2).isEqualTo(2);
		
		int actual3  = DAY.MONDAY.compareTo(DAY.WEDNESDAY);
		assertThat(actual3).isEqualTo(-2);
	}
	
	@Test
	public void name() {
		String actual = DAY.MONDAY.name();
		
		assertThat(actual).isEqualTo("MONDAY");
		assertThat(actual).isNotEqualTo("monday");
	}
	
	@Test
	public void toStr() {
		String actual = DAY.MONDAY.toString();
		
		assertThat(actual).isEqualTo("MONDAY");
		assertThat(actual).isNotEqualTo("monday");
	}
	
	@Test
	public void ordinal() {
		int actual1 = DAY.MONDAY.ordinal();
		assertThat(actual1).isEqualTo(0);
		
		int actual2 = DAY.SATURDAY.ordinal();
		assertThat(actual2).isEqualTo(5);
	}

	@Test
	public void find() {
		Optional<DAY> optionalDay1 = DAY.find("MONDAY");
		assertThat(optionalDay1.get()).isEqualTo(DAY.MONDAY);
		
		
		Optional<DAY> optionalDay2 = DAY.find("월요일");
		if (Boolean.FALSE.equals(optionalDay2.isPresent())) {
			optionalDay2 = Optional.of(DAY.MONDAY);
		}

		assertThat(optionalDay2.get()).isEqualTo(DAY.MONDAY);
	}
	
	@Test
	public void holiday() {
		boolean actual1 = DAY.holiday(DAY.FRIDAY);
		assertThat(actual1).isFalse();
		
		boolean actual2 = DAY.holiday(DAY.SUNDAY);
		assertThat(actual2).isTrue();
	}
	
	@Test
	public void isHoliday() {
		boolean actual1 = DAY.FRIDAY.isHoliday();
		assertThat(actual1).isFalse();
		
		boolean actual2 = DAY.SUNDAY.isHoliday();
		assertThat(actual2).isTrue();
	}
	
	@Test
	public void prev() {
		DAY actual = DAY.MONDAY.prev(); 
		assertThat(actual).isEqualTo(DAY.SUNDAY);
	}
	
	@Test
	public void next() {
		DAY actual = DAY.MONDAY.next(); 
		assertThat(actual).isEqualTo(DAY.TUESDAY);
	}
	
	@Test
	public void prevSunday() {
		DAY actual = DAY.SUNDAY.prev(); 
		assertThat(actual).isEqualTo(DAY.SUNDAY);
	}
	
	@Test
	public void nextSunday() {
		DAY actual = DAY.SUNDAY.next(); 
		assertThat(actual).isEqualTo(DAY.SUNDAY);
	}
}
