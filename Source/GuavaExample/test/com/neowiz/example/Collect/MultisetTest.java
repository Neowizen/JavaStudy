package com.neowiz.example.Collect;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multiset.Entry;

public class MultisetTest {

	private List<String> dataList = null;
	private HashSet<String> setItems = null; 
	private Multiset<String> multisetItems = null;
	
	@Before
	public void setUp() throws Exception {
		dataList = Arrays.asList(
								"크림빵",
								"단팥빵", "단팥빵",
								"건빵", "건빵", "건빵",
								"식빵", "식빵", "식빵", "식빵"
								);

		setItems = new HashSet<String>();
		for (String e : dataList) {
			setItems.add(e);
		}
		
		multisetItems = HashMultiset.create(dataList);
	}

	@Test
	public void HashSet_size() {
		Integer actual = setItems.size();
		
		assertThat(actual).isEqualTo(4);
	}
	
	@Test
	public void HashSet_contains() {
		boolean actual = setItems.contains("식빵");

		assertThat(actual).isTrue();
	}
	
	@Test
	public void Multiset_create() {
		Multiset<String> actual = HashMultiset.create(dataList);

		assertThat(actual.size()).isEqualTo(10);
	}
	
	@Test
	public void Multiset_size() {
		Integer actual = multisetItems.size();
		
		assertThat(actual).isEqualTo(10);
	}

	@Test
	public void Multiset_contains() {
		boolean actual = multisetItems.contains("식빵");
		
		assertThat(actual).isTrue();
	}
	
	@Test
	public void Multiset_count() {
		Integer actual = multisetItems.count("단팥빵");
		
		assertThat(actual).isEqualTo(2);
	}
	
	@Test
	public void Multiset_Entry() {
		for (Entry<String> e : multisetItems.entrySet()) {
			if ("크림빵".equals(e.getElement())) {
				assertThat(e.getCount()).isEqualTo(1);
			}
			
			if ("단팥빵".equals(e.getElement())) {
				assertThat(e.getCount()).isEqualTo(2);
			}
			
			if ("건빵".equals(e.getElement())) {
				assertThat(e.getCount()).isEqualTo(3);
			}
			
			if ("식빵".equals(e.getElement())) {
				assertThat(e.getCount()).isEqualTo(4);
			}
		}
	}
}
