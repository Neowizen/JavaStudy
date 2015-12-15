package com.neowiz.example.Collect;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Predicate;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.neowiz.example.model.Bakery;
import com.neowiz.example.model.BakeryType;

public class MapsTest {

	private List<Bakery> bakeryList = null;
	private Map<String, Bakery> mapItems = null;

	@Before
	public void setUp() throws Exception {
		bakeryList = Lists.newArrayList();

		bakeryList.add(new Bakery(BakeryType.BREAD, "크림빵", 12));
		bakeryList.add(new Bakery(BakeryType.BREAD, "소보로빵", 20));
		bakeryList.add(new Bakery(BakeryType.MILK, "딸기우유", 300));

		mapItems = Maps.uniqueIndex(bakeryList, Bakery.NAME_FILTER);
	}

	@Test
	public void Maps_newHashMap() {
		Map<String, Bakery> actual = Maps.newHashMap();

		assertThat(actual).isNotNull();
	}

	@Test
	public void Maps_convert_list_to_map() {
		Map<String, Bakery> actual = Maps.uniqueIndex(bakeryList, Bakery.NAME_FILTER);

		assertThat(actual.get("소보로빵")).isNotNull();
		assertThat(actual.get("소보로빵").getType()).isEqualTo(BakeryType.BREAD);
	}

	@Test
	public void Maps_filterEntries() {
		Map<String, Bakery> actual = Maps.filterEntries(mapItems, Bakery.MAP_ENTRY_TYPE_FINDER(BakeryType.MILK));

		assertThat(actual).isNotNull();
		assertThat(actual).hasSize(1);
	}

	@Test
	public void Maps_filterValues() {
		Map<String, Bakery> actual = Maps.filterValues(mapItems, new Predicate<Bakery>() {
			@Override
			public boolean apply(Bakery input) {
				return input.getSaleCnt() >= 20;
			}
		});

		assertThat(actual).isNotNull();
		assertThat(actual).hasSize(2);
	}

	@Test(expected = IllegalArgumentException.class)
	public void Maps_check_same_key() {
		List<Bakery> checkList = Lists.newArrayList(bakeryList);
		checkList.add(new Bakery(BakeryType.BREAD, "소보로빵", 20));

		Maps.uniqueIndex(checkList, Bakery.NAME_FILTER);
	}

}
