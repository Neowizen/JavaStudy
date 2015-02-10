package com.neowiz.example.Collect;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.neowiz.example.model.Bakery;
import com.neowiz.example.model.BakeryType;

public class ListsTest {

	private List<Bakery> bakeryList = null;
	private Set<Bakery> bakerySet = null;
	
	@Before
	public void setUp() throws Exception {
		bakeryList = Lists.newArrayList();
		
		bakeryList.add(new Bakery(BakeryType.BREAD, "크림빵", 12));
		bakeryList.add(new Bakery(BakeryType.BREAD, "소보로빵", 20));
		bakeryList.add(new Bakery(BakeryType.MILK, "딸기우유", 300));
		
		bakerySet = Sets.newHashSet();
		
		bakerySet.add(new Bakery(BakeryType.BREAD, "크림빵", 12));
		bakerySet.add(new Bakery(BakeryType.BREAD, "소보로빵", 20));
		bakerySet.add(new Bakery(BakeryType.MILK, "딸기우유", 300));
	}

	@Test
	public void Lists_newArrayList() {
		List<Bakery> actual = Lists.newArrayList();
		
		assertThat(actual).isNotNull();
	}
	
	@Test
	public void Lists_newArrayList_with_list() {
		List<Bakery> actual = Lists.newArrayList(bakeryList);
		
		assertThat(actual).isNotNull();
		assertThat(actual.get(0).getName()).isEqualTo("크림빵");
		assertThat(actual.get(1).getName()).isEqualTo("소보로빵");
		assertThat(actual.get(2).getName()).isEqualTo("딸기우유");
	}
	
	@Test
	public void Lists_newArrayList_with_parameters() {
		List<String> actual = Lists.newArrayList("크림빵", "소보로빵");
		
		assertThat(actual).isNotNull();
		assertThat(actual.get(0)).isEqualTo("크림빵");
		assertThat(actual.get(1)).isEqualTo("소보로빵");
	}

	@Test
	public void Lists_newArrayList_with_set() {
		List<Bakery> actual = Lists.newArrayList(bakerySet);

		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(3);
	}
	
	@Test
	public void Lists_parition() {
		List<List<Bakery>> actual = Lists.partition(bakeryList, 2);
System.out.println(actual);
		assertThat(actual).isNotNull();
		assertThat(actual.get(0).size()).isEqualTo(2);
		assertThat(actual.get(1).size()).isEqualTo(1);
	}
	
	@Test
	public void Lists_reverse() {
		List<Bakery> actual = Lists.reverse(bakeryList);
		
		assertThat(actual).isNotNull();
		assertThat(actual.get(0).getName()).isEqualTo("딸기우유");
		assertThat(actual.get(1).getName()).isEqualTo("소보로빵");
		assertThat(actual.get(2).getName()).isEqualTo("크림빵");
	}
	
	@Test
	public void Lists_transform() {
		List<BakeryType> actual = Lists.transform(bakeryList, Bakery.TYPE_FILTER);
		
		assertThat(actual).isNotNull();
		assertThat(actual.get(0).getClass()).hasSameClassAs(BakeryType.class);
	}
}
