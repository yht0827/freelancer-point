package com.example;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CodeEnum {

	SUCCESS("0200", "SUCESS"),
	NO_FREELANCER("1111", "NO_FREELANCER"),
	TOSS_PAYMENT_ERROR("2000", "TOSS_PAYMENT_ERROR"),
	TOSS_PAYMENT_SUCCESS("2001", "TOSS_PAYMENT_SUCCESS"),
	UNKNOWN_ERROR("9999", "UNKNOWN_ERROR");

	private final String code;
	private final String message;

}
