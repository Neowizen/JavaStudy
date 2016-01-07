package com.neowiz.example.lang3;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.regex.Pattern;

import org.apache.commons.lang3.math.NumberUtils;
import org.junit.Test;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 12. 21. 오후 3:25:43
 */
public class NumberUtilsTest {

	@Test
	public void toDouble() {
		double actual = 1234.12;
		String input = "1,234.12";
		String expect = Pattern.compile("[^0-9.-]", Pattern.CASE_INSENSITIVE).matcher(input).replaceAll("");

		assertThat(actual).isEqualTo(NumberUtils.toDouble(expect));
	}

}
