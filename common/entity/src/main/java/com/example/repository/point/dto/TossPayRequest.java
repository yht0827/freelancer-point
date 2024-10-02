package com.example.repository.point.dto;

import com.example.entity.point.Point;

public record TossPayRequest(Long memberId, String orderId, String amount, String paymentKey) {

	public Point toPoint(String payType) {
		return Point.builder()
			.payType(payType)
			.amount(Long.valueOf(this.amount))
			.memberId(this.memberId)
			.build();
	}

}
