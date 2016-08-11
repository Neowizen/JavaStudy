package com.neowiz.example.String;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Splitter;
import com.google.common.collect.Lists;

public class SplitterTest {

	private String stringMessage = null;
	private String stringParemeter = null;

	@Before
	public void setUp() throws Exception {
		stringMessage = "Hello//world //!";
		stringParemeter = "searchKey=ID&searchVal=123";
	}

	@Test
	public void Splitter_on() {
		List<String> actual = Lists.newArrayList(Splitter.on("/").split(stringMessage));

		assertThat(actual.get(0)).isEqualTo("Hello");
		assertThat(actual.get(1)).isEmpty();
		assertThat(actual.get(2)).isEqualTo("world ");
		assertThat(actual.get(3)).isEmpty();
		assertThat(actual.get(4)).isEqualTo("!");
	}

	@Test
	public void Splitter_trimResults() {
		List<String> actual = Lists.newArrayList(Splitter.on("/").trimResults().split(stringMessage));

		assertThat(actual.get(0)).isEqualTo("Hello");
		assertThat(actual.get(1)).isEmpty();
		assertThat(actual.get(2)).isEqualTo("world");
		assertThat(actual.get(3)).isEmpty();
		assertThat(actual.get(4)).isEqualTo("!");
	}

	@Test
	public void Splitter_omitEmptyStrings() {
		List<String> actual = Lists.newArrayList(Splitter.on("/").trimResults().omitEmptyStrings().split(stringMessage));

		assertThat(actual.get(0)).isEqualTo("Hello");
		assertThat(actual.get(1)).isEqualTo("world");
		assertThat(actual.get(2)).isEqualTo("!");
	}

	@Test
	public void Splitter_splitToList() {
		List<String> actual = Splitter.on("/").trimResults().omitEmptyStrings().splitToList(stringMessage);

		assertThat(actual.get(0)).isEqualTo("Hello");
		assertThat(actual.get(1)).isEqualTo("world");
		assertThat(actual.get(2)).isEqualTo("!");
	}

	@Test
	public void Splitter_MapSplitter() {
		Splitter.MapSplitter splitterMapSplitter = Splitter.on("&").trimResults().omitEmptyStrings().withKeyValueSeparator("=");

		Map<String, String> actual = splitterMapSplitter.split(stringParemeter);

		assertThat(actual.get("searchKey")).isEqualTo("ID");
		assertThat(actual.get("searchVal")).isEqualTo("123");
	}

}
