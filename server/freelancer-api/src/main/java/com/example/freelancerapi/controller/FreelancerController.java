package com.example.freelancerapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.freelancerapi.service.FreelancerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class FreelancerController {

	private final FreelancerService freelancerService;

	@GetMapping
	public String getTest() {
		return freelancerService.getTest();
	}

}
