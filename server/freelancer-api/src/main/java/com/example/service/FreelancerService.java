package com.example.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.dto.response.FreelancerDetailResponse;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public interface FreelancerService {

	Page<FreelancerResponse> getList(final FreelancerOrderRequest request, final Pageable pageable);

	Freelancer getOne(final Long id);

	FreelancerDetailResponse getDetail(final Long id, final HttpServletRequest req, final HttpServletResponse res);
}
