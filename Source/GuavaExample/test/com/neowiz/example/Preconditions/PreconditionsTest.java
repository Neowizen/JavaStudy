package com.neowiz.example.Preconditions;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public class PreconditionsTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test(expected=IllegalArgumentException.class)
	public void IllegalArgumentException() {
		int checkId = 0;

		if (checkId < 1) {
			throw new IllegalArgumentException();
		}
	}
	
	@Test(expected=IllegalArgumentException.class)
	public void checkArgument() {
		int checkId = 0;
		Preconditions.checkArgument(checkId > 0, "아이디 %s 는 0보다 커야 합니다.", checkId);
	}
	
	@Test
	public void checkArgument_message() {
		int checkId = 0;
		try {
			Preconditions.checkArgument(checkId > 0, "아이디 %s 는 0보다 커야 합니다.", checkId);	
		} catch (Exception e) {
			assertThat(e.getMessage()).isEqualTo("아이디 0 는 0보다 커야 합니다.");
		}
	}

	@Test(expected=NullPointerException.class)
	public void NullPointerException() {
		String checkName = null;

		if (checkName == null) {
			throw new NullPointerException();
		}
	}
	
	@Test(expected=NullPointerException.class)
	public void checkNotNull() {
		String checkName = null;
		Preconditions.checkNotNull(checkName, "이름 : %s 은 널일 수 없습니다.", checkName);
	}
	
	@Test
	public void checkNotNull_message() {
		String checkName = null;
		
		try {
			Preconditions.checkNotNull(checkName, "이름 : %s 은 널일 수 없습니다.", checkName);	
		} catch (Exception e) {
			assertThat(e.getMessage()).isEqualTo("이름 : null 은 널일 수 없습니다.");
		}
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void IndexOutOfBoundsException() {
		List<Integer> checkItems = Lists.newArrayList();
		checkItems.add(1);
		
		checkItems.get(1);
	}
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void checkElementIndex() {
		List<Integer> checkItems = Lists.newArrayList();
		checkItems.add(1);
		
		Preconditions.checkElementIndex(1, checkItems.size());
	}
}
