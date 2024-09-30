package com.example.application;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.entity.freelancer.Freelancer;
import com.example.service.FreelancerServiceImpl;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreelancerApplicationImpl implements FreelancerApplication {

	private final FreelancerServiceImpl freelancerService;

	@Override
	public List<Freelancer> getList() {
		return freelancerService.getList();
	}
}


