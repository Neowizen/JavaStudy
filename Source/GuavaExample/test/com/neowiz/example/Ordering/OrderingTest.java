package com.neowiz.example.Ordering;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import com.neowiz.example.model.Bakery;
import com.neowiz.example.model.BakeryComparable;
import com.neowiz.example.model.BakeryType;

public class OrderingTest {

	private List<BakeryComparable> bakeryComparableList = null;
	private BakeryComparable bakeryComparable1 = null;
	private BakeryComparable bakeryComparable2 = null;
	private BakeryComparable bakeryComparable3 = null;
	
	private List<Bakery> bakeryList = null;
	private Bakery bakery1 = null;
	private Bakery bakery2 = null;
	private Bakery bakery3 = null;
	
	private List<String> STRING_LIST = null;
	private List<Integer> INTEGER_LIST = null;
	private List<Integer> INTEGER_WITH_NULL_LIST = null;
	
	@Before
	public void setUp() throws Exception {
		bakeryComparableList = Lists.newArrayList();
		
		bakeryComparable1 = new BakeryComparable(BakeryType.BREAD, "크림빵", 20);
		bakeryComparable2 = new BakeryComparable(BakeryType.BREAD, "소보로빵", 12);
		bakeryComparable3 = new BakeryComparable(BakeryType.BREAD, "건빵", 300);
		
		bakeryComparableList.add(bakeryComparable1);
		bakeryComparableList.add(bakeryComparable2);
		bakeryComparableList.add(bakeryComparable3);
		
		
		bakeryList = Lists.newArrayList();
		
		bakery1 = new Bakery(BakeryType.BREAD, "크림빵", 20);
		bakery2 = new Bakery(BakeryType.BREAD, "소보로빵", 12);
		bakery3 = new Bakery(BakeryType.BREAD, "건빵", 300);
		
		bakeryList.add(bakery1);
		bakeryList.add(bakery2);
		bakeryList.add(bakery3);
		
		STRING_LIST = Lists.newArrayList("D", "B", "C", "A");
		INTEGER_LIST = Lists.newArrayList(4, 2, 3, 1);
		INTEGER_WITH_NULL_LIST = Lists.newArrayList(null, 2, 3, 1);
	}

	@Test
	public void Comparable_sort() {
		Collections.sort(bakeryComparableList);
		
		assertThat(bakeryComparableList.get(0).getSaleCnt()).isEqualTo(12);
		assertThat(bakeryComparableList.get(1).getSaleCnt()).isEqualTo(20);
		assertThat(bakeryComparableList.get(2).getSaleCnt()).isEqualTo(300);
	}
	
	@Test
	public void Comparable_reverse() {
		Collections.sort(bakeryComparableList);
		Collections.reverse(bakeryComparableList);
		
		assertThat(bakeryComparableList.get(0).getSaleCnt()).isEqualTo(300);
		assertThat(bakeryComparableList.get(1).getSaleCnt()).isEqualTo(20);
		assertThat(bakeryComparableList.get(2).getSaleCnt()).isEqualTo(12);
	}
	
	@Test
	public void Ordering_sort_order() {
		Collections.sort(bakeryList, Bakery.SALE_CNT_ORDERING);
		
		assertThat(bakeryList.get(0).getSaleCnt()).isEqualTo(12);
		assertThat(bakeryList.get(1).getSaleCnt()).isEqualTo(20);
		assertThat(bakeryList.get(2).getSaleCnt()).isEqualTo(300);
	}
	
	@Test
	public void Ordering_reverse_order() {
		Collections.sort(bakeryList, Bakery.SALE_CNT_ORDERING.reverse());
		
		assertThat(bakeryList.get(0).getSaleCnt()).isEqualTo(300);
		assertThat(bakeryList.get(1).getSaleCnt()).isEqualTo(20);
		assertThat(bakeryList.get(2).getSaleCnt()).isEqualTo(12);
	}

	@Test
	public void Ordering_sort_name_length() {
		Collections.sort(bakeryList, Bakery.NAME_ORDERING.nullsFirst());
		
		assertThat(bakeryList.get(0).getName()).isEqualTo("건빵");
		assertThat(bakeryList.get(1).getName()).isEqualTo("크림빵");
		assertThat(bakeryList.get(2).getName()).isEqualTo("소보로빵");
	}
	
	@Test
	public void Ordering_reverse_name_length() {
		Collections.sort(bakeryList, Bakery.NAME_ORDERING.nullsFirst().reverse());
		
		assertThat(bakeryList.get(0).getName()).isEqualTo("소보로빵");
		assertThat(bakeryList.get(1).getName()).isEqualTo("크림빵");
		assertThat(bakeryList.get(2).getName()).isEqualTo("건빵");
	}
	
	@Test
	public void Ordering_min_string_value() {
		String actual = Ordering.from(String.CASE_INSENSITIVE_ORDER).min(STRING_LIST);
		
		assertThat(actual).isEqualTo("A");
	}
	
	@Test
	public void Ordering_max_string_value() {
		String actual = Ordering.from(String.CASE_INSENSITIVE_ORDER).max(STRING_LIST);
		
		assertThat(actual).isEqualTo("D");
	}
	
	@Test
	public void Ordering_min_number_value() {
		Integer actual = Ordering.natural().min(INTEGER_LIST);
		
		assertThat(actual).isEqualTo(1);
	}
	
	@Test
	public void Ordering_max_number_value() {
		Integer actual = Ordering.natural().max(INTEGER_LIST);
		
		assertThat(actual).isEqualTo(4);
	}
	
	@Test
	public void Ordering_leastOf_number() {
		List<Integer> actual = Ordering.natural().leastOf(INTEGER_LIST, INTEGER_LIST.size());
		
		assertThat(actual.get(0)).isEqualTo(1);
	}
	
	@Test
	public void Ordering_greatestOf_number() {
		List<Integer> actual = Ordering.natural().greatestOf(INTEGER_LIST, INTEGER_LIST.size());
		
		assertThat(actual.get(0)).isEqualTo(4);
	}
	
	@Test
	public void Ordering_isOrdered_false() {
		boolean actual = Ordering.natural().isOrdered(INTEGER_LIST);
		
		assertThat(actual).isFalse();
	}
	
	@Test
	public void Ordering_isOrdered_true() {
		Collections.sort(INTEGER_LIST, Ordering.natural());
		
		boolean actual = Ordering.natural().isOrdered(INTEGER_LIST);
		
		assertThat(actual).isTrue();
	}
	
	@Test
	public void Ordering_nullsFirst() {
		Collections.sort(INTEGER_WITH_NULL_LIST, Ordering.natural().nullsFirst());
		
		assertThat(INTEGER_WITH_NULL_LIST.get(0)).isNull();
	}
	
	@Test
	public void Ordering_nullsLast() {
		Collections.sort(INTEGER_WITH_NULL_LIST, Ordering.natural().nullsLast());
		
		assertThat(INTEGER_WITH_NULL_LIST.get(3)).isNull();
	}
	
	@Test
	public void Ordering_onResultOf_min() {
		Ordering<Bakery> bakeryOrdering = Ordering.natural().nullsFirst().onResultOf(Bakery.SALE_CNT_FILTER);

		Bakery bakery = bakeryOrdering.min(bakeryList);
		
		assertThat(bakery.getSaleCnt()).isEqualTo(12);
	}
	
	@Test
	public void Ordering_onResultOf_max() {
		Ordering<Bakery> bakeryOrdering = Ordering.natural().nullsFirst().onResultOf(Bakery.SALE_CNT_FILTER);

		Bakery bakery = bakeryOrdering.max(bakeryList);
		
		assertThat(bakery.getSaleCnt()).isEqualTo(300);
	}
}
