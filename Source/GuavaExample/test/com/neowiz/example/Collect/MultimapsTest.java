package com.neowiz.example.Collect;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ImmutableListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimaps;
import com.neowiz.example.model.Bakery;
import com.neowiz.example.model.BakeryType;

public class MultimapsTest {

	private List<Bakery> bakeryList = null;
	
	@Before
	public void setUp() throws Exception {
		bakeryList = Lists.newArrayList();
		
		bakeryList.add(new Bakery(BakeryType.BREAD, "크림빵", 12));
		bakeryList.add(new Bakery(BakeryType.BREAD, "소보로빵", 20));
		bakeryList.add(new Bakery(BakeryType.MILK, "딸기우유", 300));
	}
	
	@Test
	public void Multimaps_index() {
		ImmutableListMultimap<BakeryType, Bakery> actual = Multimaps.index(bakeryList, Bakery.TYPE_FILTER);
		
		assertThat(actual.size()).isEqualTo(3);
		assertThat(actual.get(BakeryType.BREAD).size()).isEqualTo(2);
		assertThat(actual.get(BakeryType.MILK).size()).isEqualTo(1);
	}
}
