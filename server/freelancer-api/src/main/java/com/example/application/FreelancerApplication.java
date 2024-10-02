package com.example.application;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.repository.freelancer.dto.response.FreelancerDetailResponse;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FreelancerApplication {

	Page<FreelancerResponse> getList(final FreelancerOrderRequest request, final Pageable pageable);

	FreelancerDetailResponse getDetail(final Long id, final HttpServletRequest req, final HttpServletResponse res);
}
