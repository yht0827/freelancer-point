package com.example.controller;

import static com.example.CodeEnum.*;
import static com.example.ResponseHandler.*;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CommonResponse;
import com.example.application.PointApplicationImpl;
import com.example.repository.point.dto.TossPayRequest;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/point")
@RequiredArgsConstructor
public class PointController {

	private final PointApplicationImpl pointApplication;

	@PostMapping(value = "/toss")
	public CommonResponse<?> tossPayment(@RequestBody final TossPayRequest tossPayRequest) {
		pointApplication.tossPayment(tossPayRequest);
		return response(TOSS_PAYMENT_SUCCESS);
	}

}
