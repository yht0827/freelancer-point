package com.example.application;

import com.example.repository.point.dto.TossPayRequest;

public interface PointApplication {

	void tossPayment(final TossPayRequest tossPayRequest);
}
