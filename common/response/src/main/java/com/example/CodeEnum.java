package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {

	SUCCESS("0200", "SUCESS"),
	UNKNOWN_ERROR("9999", "UNKNOWN_ERROR");

	private final String code;
	private final String message;

}
