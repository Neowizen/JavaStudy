package com.neowiz.example.Collect;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Optional;
import com.google.common.base.Predicates;
import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import com.neowiz.example.model.Bakery;
import com.neowiz.example.model.BakeryType;

public class IterablesTest {

	private List<Bakery> bakeryList = null;
	private List<String> stringList = null;
	
	@Before
	public void setUp() throws Exception {
		bakeryList = Lists.newArrayList();
		
		bakeryList.add(new Bakery(BakeryType.BREAD, "크림빵", 12));
		bakeryList.add(new Bakery(BakeryType.BREAD, "소보로빵", 20));
		bakeryList.add(new Bakery(BakeryType.BREAD, "건빵", 0));
		bakeryList.add(new Bakery(BakeryType.BREAD, "식빵", 10));
		bakeryList.add(new Bakery(BakeryType.MILK, "딸기우유", 300));
		bakeryList.add(new Bakery(BakeryType.MILK, "초코우유", 300));
		bakeryList.add(new Bakery(BakeryType.JUICE, "사과주스", 300));
		
		stringList = Lists.newArrayList(null, "크림빵", null, "딸기우유");
	}

	@Test
	public void Iterables_filter() {
		List<Bakery> actual = Lists.newArrayList(Iterables.filter(bakeryList, Bakery.TYPE_FINDER(BakeryType.MILK)));
		
		assertThat(actual).isNotEmpty();
		assertThat(actual.size()).isEqualTo(2);
	}

	@Test
	public void Iterables_combine() {
		Iterable<Bakery> milks = Iterables.filter(bakeryList, Bakery.TYPE_FINDER(BakeryType.MILK));
		Iterable<Bakery> juices = Iterables.filter(bakeryList, Bakery.TYPE_FINDER(BakeryType.JUICE));
		
		List<Bakery> actual = Lists.newArrayList(Iterables.concat(milks, juices));
		
		assertThat(actual).isNotEmpty();
		assertThat(actual.size()).isEqualTo(3);
	}
	
	@Test
	public void Iterables_find() {
		Bakery actual = Iterables.find(bakeryList, Bakery.TYPE_FINDER(BakeryType.MILK));
		
		assertThat(actual).isNotNull();
		assertThat(actual.getName()).isEqualTo("딸기우유");
	}
	
	@Test
	public void Iterables_find_first_non_null() {
		String actual = Iterables.find(stringList, Predicates.notNull());
		
		assertThat(actual).isNotNull();
		assertThat(actual).isEqualTo("크림빵");
	}
	
	@Test
	public void Iterables_tryFind() {
		Optional<Bakery> actual = Iterables.tryFind(bakeryList, Bakery.TYPE_FINDER(BakeryType.MILK));
		
		assertThat(actual.isPresent()).isTrue();
		assertThat(actual.get().getName()).isEqualTo("딸기우유");
	}
	
	@Test
	public void Iterables_getFirst() {
		Bakery actual = Iterables.getFirst(bakeryList, null);
		
		assertThat(actual).isNotNull();
		assertThat(actual.getName()).isEqualTo("크림빵");
	}
	
	@Test
	public void Iterables_getLast() {
		Bakery actual = Iterables.getLast(bakeryList, null);
		
		assertThat(actual).isNotNull();
		assertThat(actual.getName()).isEqualTo("사과주스");
	}
	
	@Test
	public void Iterables_all() {
		boolean actual = Iterables.all(bakeryList, Bakery.TYPE_FINDER(BakeryType.MILK));
		
		assertThat(actual).isFalse();
	}
	
	@Test
	public void Iterables_any() {
		boolean actual = Iterables.any(bakeryList, Bakery.TYPE_FINDER(BakeryType.MILK));
		
		assertThat(actual).isTrue();
	}
	
	@Test
	public void Iterables_size() {
		int actual = Iterables.size(bakeryList);
		
		assertThat(actual).isEqualTo(7);
	}
	
	@Test
	public void Iterables_get() {
		Bakery actual = Iterables.get(bakeryList, 6);

		assertThat(actual).isNotNull();
		assertThat(actual.getName()).isEqualTo("사과주스");
	}
	
	@Test
	public void Iterables_transform() {
		List<BakeryType> actual = Lists.newArrayList(Iterables.transform(bakeryList, Bakery.TYPE_FILTER));
		
		assertThat(actual).isNotNull();
		assertThat(actual.size()).isEqualTo(7);
		assertThat(actual.get(0).getClass()).hasSameClassAs(BakeryType.class);
	}
}
