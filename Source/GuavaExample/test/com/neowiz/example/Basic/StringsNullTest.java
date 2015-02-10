package com.neowiz.example.Basic;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Strings;

public class StringsNullTest {
	
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void Strings_nullToEmpty_StringNotEmpty() {
		String actual = null;
		
		actual = Strings.nullToEmpty("TEST");
		
		assertThat(actual).isNotEmpty();
		assertThat(actual).isEqualTo("TEST");
	}
	
	@Test
	public void Strings_nullToEmpty_StringEmpty() {
		String actual = null;
		
		actual = Strings.nullToEmpty("");
		
		assertThat(actual).isEmpty();
		assertThat(actual).isEqualTo("");
	}

	@Test
	public void Strings_nullToEmpty_StringNull() {
		String actual = null;
		
		actual = Strings.nullToEmpty(null);
		
		assertThat(actual).isEmpty();
		assertThat(actual).isEqualTo("");
	}
	
	@Test
	public void Strings_emptyToNull_StringNotEmpty() {
		String actual = null;
		
		actual = Strings.emptyToNull("TEST");
		
		assertThat(actual).isNotEmpty();
		assertThat(actual).isEqualTo("TEST");
	}
	
	@Test
	public void Strings_emptyToNull_StringEmpty() {
		String actual = null;
		
		actual = Strings.emptyToNull("");
		
		assertThat(actual).isNull();
		assertThat(actual).isEqualTo(null);
	}
	
	@Test
	public void Strings_emptyToNull_StringNull() {
		String actual = null;
		
		actual = Strings.emptyToNull(null);
		
		assertThat(actual).isNull();
		assertThat(actual).isEqualTo(null);
	}
	
	@Test
	public void Strings_isNullOrEmpty_StringNotEmpty() {
		Boolean actual = null;
		
		actual = Strings.isNullOrEmpty("TEST");
		
		assertThat(actual).isFalse();
	}
	
	@Test
	public void Strings_isNullOrEmpty_StringEmpty() {
		Boolean actual = null;
		
		actual = Strings.isNullOrEmpty("");
		
		assertThat(actual).isTrue();
	}
	
	@Test
	public void Strings_isNullOrEmpty_StringNull() {
		Boolean actual = null;
		
		actual = Strings.isNullOrEmpty(null);
		
		assertThat(actual).isTrue();
	}
}
