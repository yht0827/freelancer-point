package com.example.repository.freelancer.dto.sort;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum OrderEnum {

	NAME("name"),
	VIEW_COUNT("viewCount"),
	DATE("date");

	private final String condition;

}
