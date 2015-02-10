package com.neowiz.example.Collect;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Sets;

public class SetsTest {

	private List<String> dataList = null;
	private Set<String> setItems = null;
	
	@Before
	public void setUp() throws Exception {
		dataList = Arrays.asList(
				"크림빵",
				"단팥빵", "단팥빵",
				"건빵", "건빵", "건빵",
				"식빵", "식빵", "식빵", "식빵"
				);
		
		setItems = Sets.newHashSet(dataList);
	}

	@Test
	public void Set_newHashSet() {
		Set<String> actual = Sets.newHashSet(dataList);

		assertThat(actual.size()).isEqualTo(4);
	}

	@Test
	public void Set_filter() {
		Set<String> actual = Sets.filter(setItems, new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return "건빵".equals(input) || "크림빵".equals(input);
			}
		});
		
		assertThat(actual.size()).isEqualTo(2);
	}
	
	@Test
	public void Set_union() {
		Set<String> milk = Sets.newHashSet("딸기우유");
		Set<String> bread = Sets.filter(setItems, new Predicate<String>() {
			@Override
			public boolean apply(String input) {
				return "식빵".equals(input);
			}
		});

		Set<String> actual = Sets.union(milk, bread);

		assertThat(actual.contains("딸기우유")).isTrue();
		assertThat(actual.contains("식빵")).isTrue();
		assertThat(actual.contains("단팥빵")).isFalse();
	}
}
