package com.neowiz.example.Basic;

import static org.fest.assertions.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Enums;
import com.google.common.base.Optional;
import com.google.common.base.Strings;
import com.neowiz.example.model.Bakery;
import com.neowiz.example.model.BakeryType;

public class OptionalTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void Optional_of() {
		Optional<Integer> possible = Optional.of(5);
		
		assertThat(possible.isPresent()).isTrue();
		assertThat(possible.get()).isEqualTo(5);
	}
	
	@Test(expected=NullPointerException.class)
	public void Optional_of_Exception() {
		Optional<Integer> possible = Optional.of(null);
		
		assertThat(possible.isPresent()).isFalse();
	}
	
	@Test
	public void Optional_absent() {
		Optional<Integer> possible = Optional.absent();
		
		assertThat(possible.isPresent()).isFalse();
	}

	@Test
	public void Optional_fromNullable() {
		Optional<Integer> possible = Optional.fromNullable(null);
		Optional<Integer> possible2 = Optional.fromNullable(2);
		
		assertThat(possible.isPresent()).isFalse();
		assertThat(possible.or(possible2).get()).isEqualTo(2);
		assertThat(possible.or(3)).isEqualTo(3);
	}
	
	@Test
	public void Optional_Example_Model() {
		Optional<Bakery> bakery = Optional.fromNullable(new Bakery(BakeryType.BREAD, "크림빵"));
		
		if (bakery.isPresent()) {
			assertThat(bakery.get().getType()).isEqualTo(BakeryType.BREAD);
			assertThat(bakery.get().getName()).isEqualTo("크림빵");
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void Optional_Example_Enums_value_null() {
		Optional<BakeryType> downloadType = Enums.getIfPresent(BakeryType.class, null);

		assertThat(downloadType.isPresent()).isFalse();
	}
	
	@Test
	public void Optional_Example_Enums_value_empty() {
		Optional<BakeryType> downloadType = Enums.getIfPresent(BakeryType.class, "");

		assertThat(downloadType.isPresent()).isFalse();
	}
	
	@Test
	public void Optional_Example_Enums() {
		Optional<BakeryType> downloadType = Enums.getIfPresent(BakeryType.class, Strings.nullToEmpty("BREAD"));

		assertThat(downloadType.isPresent()).isTrue();
		assertThat(downloadType.get()).isEqualTo(BakeryType.BREAD);
	}
}
