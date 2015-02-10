package com.neowiz.example.Cache;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.Before;
import org.junit.Test;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.collect.Maps;

public class LoadingCacheTest {
	
	private Map<String, String> DATA_ITEMS_PRIMARY_KEY = null;
	private Map<String, String> DATA_ITEMS_COMPOSITE_KEY = null;
	
	private static final long CACHE_MAX_SIZE = 1000L;
	private static final int CACHE_5_MINUTES = 5;
	
	private LoadingCache<String, String> CACHE_ITEMS_PRIMARY_KEY = CacheBuilder.newBuilder().softValues().maximumSize(CACHE_MAX_SIZE).expireAfterWrite(CACHE_5_MINUTES, TimeUnit.MINUTES).build(
			new CacheLoader<String, String>() {
				@Override
				public String load(String key) throws Exception {
					return getData(key);
				}
			});
	
	private LoadingCache<Pair<String, String>, String> CACHE_ITEMS_COMPOSITE_KEY = CacheBuilder.newBuilder().softValues().maximumSize(CACHE_MAX_SIZE).expireAfterWrite(CACHE_5_MINUTES, TimeUnit.MINUTES).build(
			new CacheLoader<Pair<String, String>, String>() {
				@Override
				public String load(Pair<String, String> key) throws Exception {
					return getData(key.getLeft(), key.getRight());
				}
			});
	
	private String getData(String key) {
		System.out.println(">>> NO CACHE!");
		return DATA_ITEMS_PRIMARY_KEY.get(key);
	}
	
	private String getData(String key1, String key2) {
		System.out.println(">>> NO CACHE!");
		return DATA_ITEMS_COMPOSITE_KEY.get(key1 + key2);
	}
	
	@Before
	public void setUp() throws Exception {
		DATA_ITEMS_PRIMARY_KEY = Maps.newHashMap();
		
		DATA_ITEMS_PRIMARY_KEY.put("1", "1번입니다.");
		DATA_ITEMS_PRIMARY_KEY.put("2", "2번입니다.");
		DATA_ITEMS_PRIMARY_KEY.put("3", "3번입니다.");
		DATA_ITEMS_PRIMARY_KEY.put("4", "4번입니다.");
		DATA_ITEMS_PRIMARY_KEY.put("5", "5번입니다.");
		
		
		DATA_ITEMS_COMPOSITE_KEY = Maps.newHashMap();
		
		DATA_ITEMS_COMPOSITE_KEY.put("KEY1", "KEY1번입니다.");
		DATA_ITEMS_COMPOSITE_KEY.put("KEY2", "KEY2번입니다.");
		DATA_ITEMS_COMPOSITE_KEY.put("KEY3", "KEY3번입니다.");
		DATA_ITEMS_COMPOSITE_KEY.put("KEY4", "KEY4번입니다.");
		DATA_ITEMS_COMPOSITE_KEY.put("KEY5", "KEY5번입니다.");
	}
	
	@Test
	public void primaryKeyTest() {
		String actual1 = CACHE_ITEMS_PRIMARY_KEY.getUnchecked("2");
		assertThat(actual1).isEqualTo("2번입니다.");
		
		String actual2 = CACHE_ITEMS_PRIMARY_KEY.getUnchecked("2");
		assertThat(actual2).isEqualTo("2번입니다.");
		
		String actual3 = CACHE_ITEMS_PRIMARY_KEY.getUnchecked("2");
		assertThat(actual3).isEqualTo("2번입니다.");
		
		String actual4 = CACHE_ITEMS_PRIMARY_KEY.getUnchecked("2");
		assertThat(actual4).isEqualTo("2번입니다.");
		
		String actual5 = CACHE_ITEMS_PRIMARY_KEY.getUnchecked("2");
		assertThat(actual5).isEqualTo("2번입니다.");
	}
	
	@Test
	public void compositeKeyTest() {
		String actual1 = CACHE_ITEMS_COMPOSITE_KEY.getUnchecked(Pair.of("KEY", "5"));
		assertThat(actual1).isEqualTo("KEY5번입니다.");
		
		String actual2 = CACHE_ITEMS_COMPOSITE_KEY.getUnchecked(Pair.of("KEY", "5"));
		assertThat(actual2).isEqualTo("KEY5번입니다.");
		
		String actual3 = CACHE_ITEMS_COMPOSITE_KEY.getUnchecked(Pair.of("KEY", "5"));
		assertThat(actual3).isEqualTo("KEY5번입니다.");
		
		String actual4 = CACHE_ITEMS_COMPOSITE_KEY.getUnchecked(Pair.of("KEY", "5"));
		assertThat(actual4).isEqualTo("KEY5번입니다.");
		
		String actual5 = CACHE_ITEMS_COMPOSITE_KEY.getUnchecked(Pair.of("KEY", "5"));
		assertThat(actual5).isEqualTo("KEY5번입니다.");
		
	}
}
