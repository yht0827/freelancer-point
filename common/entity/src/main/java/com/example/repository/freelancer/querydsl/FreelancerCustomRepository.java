package com.example.repository.freelancer.querydsl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;

public interface FreelancerCustomRepository {

	Page<FreelancerResponse> findAllByOrderCondition(final FreelancerOrderRequest request, final Pageable pageable);
}
