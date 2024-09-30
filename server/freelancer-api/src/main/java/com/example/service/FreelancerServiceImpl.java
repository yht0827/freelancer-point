package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.FreelancerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

	private final FreelancerRepository freelancerRepository;

	@Override
	@Transactional(readOnly = true)
	public List<Freelancer> getList() {
		return freelancerRepository.findAll();
	}

}
