package com.neowiz.example.model;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class DTO {
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
