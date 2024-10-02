package com.example.application;

import static com.example.CodeEnum.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CustomException;
import com.example.entity.freelancer.Freelancer;
import com.example.entity.point.Point;
import com.example.repository.freelancer.FreelancerRepository;
import com.example.repository.point.dto.TossPayRequest;
import com.example.service.TossPayService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PointApplicationImpl implements PointApplication {

	private final TossPayService tossPayService;
	private final FreelancerRepository freelancerRepository;

	@Transactional
	public void tossPayment(final TossPayRequest tossPayRequest) {
		Freelancer freelancer = freelancerRepository.findById(tossPayRequest.memberId())
			.orElseThrow(() -> new CustomException(NO_FREELANCER));

		Point point = tossPayService.tossConfirm(tossPayRequest);

		tossPayService.pay(freelancer, point);
	}
}
