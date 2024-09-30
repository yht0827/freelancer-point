package com.example.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.application.FreelancerApplicationImpl;
import com.example.entity.freelancer.Freelancer;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/freelancer")
@RequiredArgsConstructor
public class FreelancerController {

	private final FreelancerApplicationImpl freelancerApplication;

	@GetMapping("/list")
	public List<Freelancer> getList() {
		return freelancerApplication.getList();
	}

	@GetMapping("/test")
	public String getTest() {
		return "test";
	}

}
