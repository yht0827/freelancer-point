package com.example.controller;

import static com.example.ResponseHandler.*;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.CommonResponse;
import com.example.application.FreelancerApplicationImpl;
import com.example.repository.freelancer.dto.response.FreelancerDetailResponse;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/freelancer")
@RequiredArgsConstructor
public class FreelancerController {

	private final FreelancerApplicationImpl freelancerApplication;

	@GetMapping("/list")
	public Page<FreelancerResponse> getList(final FreelancerOrderRequest request, final Pageable pageable) {
		return freelancerApplication.getList(request, pageable);
	}

	@GetMapping("/{id}")
	public CommonResponse<FreelancerDetailResponse> getDetail(@PathVariable final Long id, final HttpServletRequest req,
		final HttpServletResponse res) {
		return success(freelancerApplication.getDetail(id, req, res));
	}

}
