package com.neowiz.example.generic;

import static org.fest.assertions.api.Assertions.assertThat;

import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import com.neowiz.example.model.DAY;
import com.neowiz.example.model.DataNormal;
import com.neowiz.example.model.GenericsBase;
import com.neowiz.example.model.GenericsExtends;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 25. 오후 2:00:37
 */
public class GenericsTest {

	private GenericsBase<DAY> genericsBase;
	
	@Before
	public void setUp() {
		genericsBase = new GenericsBase<DAY>();
		genericsBase.set(DAY.MONDAY);
	}
	
	@Test
	public void create() {
		assertThat(genericsBase.get() instanceof DAY).isTrue();
	}

	@Test
	public void toList() {
		List<DAY> actual = genericsBase.toList();
		
		assertThat(actual).isNotEmpty();
		assertThat(actual.get(0)).isEqualTo(DAY.MONDAY);
	}
	
	@Test
	public void toSet() {
		Set<DAY> actual = genericsBase.toSet();
		
		assertThat(actual).isNotEmpty();
		assertThat(actual.size()).isEqualTo(1);
	}
	
	@Test
	public void extendsTest() {
		GenericsExtends<DataNormal> genericsExtends = new GenericsExtends<DataNormal>();
		
		assertThat(genericsExtends).isNotNull();
	}
	
	@Test
	public void sub() {
		GenericsBase<Number> genericsBase = new GenericsBase<Number>();
		genericsBase.set(new Integer(1));
		genericsBase.set(new Double(1.1));
		
		assertThat(genericsBase.get()).isEqualTo(1.1);
	}
}
