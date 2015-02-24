package com.neowiz.example.enumeration;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.neowiz.example.constant.DAY;
import com.neowiz.example.constant.MONTH;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 23. 오후 10:06:02
 */
public class ConstantTest {

	@Test
	public void equals() {
		boolean actual = false;

		int day = DAY.MONDAY;
		int month = MONTH.JANUARY;
		
		if (day == month) {
			actual = true;
		}
		
		// 상수는 비교할 수 없음. complie error
		//if (DAY.MONDAY == MONTH.JANUARY) {
		//	actual = true;
		//}
		
		assertThat(actual).isTrue();
	}

}
