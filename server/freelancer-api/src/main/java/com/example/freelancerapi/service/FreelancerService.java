package com.example.freelancerapi.service;

import org.springframework.stereotype.Service;

import com.example.entity.freelancer.FreelancerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreelancerService {

	private final FreelancerRepository freelancerRepository;

	public String getTest() {
		return freelancerRepository.getTest();
	}

}
