package com.example;

public class ResponseHandler {

	public static <T> CommonResponse<T> success(T info) {
		return CommonResponse.<T>builder()
			.code(CodeEnum.SUCCESS.getCode())
			.message(CodeEnum.SUCCESS.getMessage())
			.info(info)
			.build();
	}

	public static <T> CommonResponse<T> response(CodeEnum codeEnum) {
		return CommonResponse.<T>builder()
			.code(codeEnum.getCode())
			.message(codeEnum.getMessage())
			.build();
	}

	public static <T> CommonResponse<T> response(CodeEnum codeEnum, T info) {
		return CommonResponse.<T>builder()
			.code(codeEnum.getCode())
			.message(codeEnum.getMessage())
			.info(info)
			.build();
	}

}
