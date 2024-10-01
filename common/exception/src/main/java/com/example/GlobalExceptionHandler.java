package com.example;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = CustomException.class)
	public CommonResponse<?> handleCustomException(CustomException e) {
		return CommonResponse.builder()
			.code(e.getCode())
			.message(e.getMessage())
			.build();
	}

	@ExceptionHandler(value = Exception.class)
	public CommonResponse<?> handleException(Exception e) {
		return CommonResponse.builder()
			.code(CodeEnum.UNKNOWN_ERROR.getCode())
			.message(CodeEnum.UNKNOWN_ERROR.getMessage())
			.build();
	}

}
