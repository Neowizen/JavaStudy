package com.neowiz.example.Collect;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;

public class MultimapTest {

	private Map<String, List<String>> mapItems = null;
	private Multimap<String, String> multimapItems = null;
	
	@Before
	public void setUp_Map() throws Exception {
		mapItems = new HashMap<String, List<String>>();
		
		setHashMapItem("빵", "크림빵");
		setHashMapItem("빵", "단팥빵");
		setHashMapItem("빵", "소보로빵");
		
		setHashMapItem("우유", "초코우유");
		setHashMapItem("우유", "딸기우유");
		
		setHashMapItem("과일", "싫어");
	}
	
	private void setHashMapItem(String key, String value) {
		if (mapItems.containsKey(key)) {
			List<String> itemList = mapItems.get(key);
			itemList.add(value);
		}
		else {
			List<String> itemList = new ArrayList<String>();
			itemList.add(value);

			mapItems.put(key, itemList);
		}
	}
	
	@Before
	public void setUp_Multimap() throws Exception {
		multimapItems = ArrayListMultimap.create();
		
		multimapItems.put("빵", "크림빵");
		multimapItems.put("빵", "단팥빵");
		multimapItems.put("빵", "소보로빵");
		
		multimapItems.put("우유", "초코우유");
		multimapItems.put("우유", "딸기우유");
		
		multimapItems.put("과일", "싫어");
	}

	@Test
	public void HashMap_size() {
		Integer actual = mapItems.size();
		
		assertThat(actual).isEqualTo(3);
	}
	
	@Test
	public void HashMap_containsKey() {
		boolean actual = mapItems.containsKey("빵");
		
		assertThat(actual).isTrue();
	}
	
	@Test
	public void HashMap_containsValue() {
		boolean actual = mapItems.containsValue("초코우유");
		
		assertThat(actual).isFalse();
	}
	
	@Test
	public void HashMap_get() {
		List<String> actual = mapItems.get("우유");
		
		assertThat(actual.size()).isEqualTo(2);
	}

	@Test
	public void Multimap_create() {
		Multimap<String, String> actual = ArrayListMultimap.create();
		
		actual.put("빵", "소보로빵");
		actual.put("우유", "초코우유");
		
		assertThat(actual.size()).isEqualTo(2);
	}
	
	@Test
	public void Multimap_size() {
		Integer actual = multimapItems.size();
		
		assertThat(actual).isEqualTo(6);
	}
	
	@Test
	public void Multimap_containsKey() {
		boolean actual = multimapItems.containsKey("빵");
		
		assertThat(actual).isTrue();
	}
	
	@Test
	public void Multimap_containsValue() {
		boolean actual = multimapItems.containsValue("초코우유");
		
		assertThat(actual).isTrue();
	}
	
	@Test
	public void Multimap_get() {
		List<String> actual = Lists.newArrayList(multimapItems.get("우유"));
		
		assertThat(actual.size()).isEqualTo(2);
	}
	
	@Test
	public void Multimap_asMap() {
		Map<String, Collection<String>> actual = multimapItems.asMap();

		assertThat(actual.size()).isEqualTo(3);
	}
}
