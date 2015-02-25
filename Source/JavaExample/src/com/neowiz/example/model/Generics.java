package com.neowiz.example.model;

import java.util.List;
import java.util.Set;

/**
 * @author nal<daygoods@neowiz.com>
 * @date 2015. 2. 25. 오후 1:41:49
 */
public interface Generics<T> {
	List<T> toList();
	Set<T> toSet();
}
