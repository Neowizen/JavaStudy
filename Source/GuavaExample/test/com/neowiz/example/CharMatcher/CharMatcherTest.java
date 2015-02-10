package com.neowiz.example.CharMatcher;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Test;

import com.google.common.base.CharMatcher;

public class CharMatcherTest {

	@Test
	public void whitespace_removeFrom() {
		String testText = "     Mahesh     Parashar ";
		String actual = CharMatcher.WHITESPACE.removeFrom(testText);

		assertThat(actual).isEqualTo("MaheshParashar");
	}
}
