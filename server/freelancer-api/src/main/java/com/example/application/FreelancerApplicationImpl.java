package com.example.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.example.repository.freelancer.dto.response.FreelancerDetailResponse;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;
import com.example.service.FreelancerServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreelancerApplicationImpl implements FreelancerApplication {

	private final FreelancerServiceImpl freelancerService;

	public Page<FreelancerResponse> getList(final FreelancerOrderRequest request, final Pageable pageable) {
		return freelancerService.getList(request, pageable);
	}

	public FreelancerDetailResponse getDetail(
		final Long id, final HttpServletRequest req, final HttpServletResponse res) {
		return freelancerService.getDetail(id, req, res);
	}
}


