package com.neowiz.example.String;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class JoinerTest {

	private List<String> stringList = null;
	private List<String> stringWithNullList = null;
	private Map<String, Object> stringMap = null;

	@Before
	public void setUp() throws Exception {
		stringList = Lists.newArrayList();

		stringList.add("Hello");
		stringList.add("world");
		stringList.add("!");

		stringWithNullList = Lists.newArrayList();

		stringWithNullList.add("Hello");
		stringWithNullList.add(null);
		stringWithNullList.add("world");
		stringWithNullList.add("!");

		stringMap = Maps.newHashMap();
		stringMap.put("searchKey", "ID");
		stringMap.put("searchVal", 123);
	}

	@Test
	public void Joiner_on() {
		String actual = Joiner.on("/").useForNull("null").join(stringList);

		assertThat(actual).isEqualTo("Hello/world/!");
	}

	@Test
	public void Joiner_skipNulls() {
		String actual = Joiner.on("/").skipNulls().join(stringWithNullList);

		assertThat(actual).isEqualTo("Hello/world/!");
	}

	@Test
	public void Joiner_MapJoiner() {
		Joiner.MapJoiner joinerMapJoiner = Joiner.on("&").withKeyValueSeparator("=");

		String actual = joinerMapJoiner.useForNull("null").join(stringMap);

		assertThat(actual).isEqualTo("searchKey=ID&searchVal=123");
	}

}
