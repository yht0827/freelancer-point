package com.example.freelancerapi;

import java.time.LocalDateTime;
import java.util.List;

import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.dto.response.FreelancerResponse;

public class FreelancerTestDto {

	public static List<Freelancer> getFreelancerList() {

		Freelancer freelancer = Freelancer.builder()
			.id(1L)
			.password("Qwe123!@#")
			.email("aaa@naver.com")
			.name("김개발")
			.viewCount(0L)
			.point(0L)
			.build();

		Freelancer freelancer1 = Freelancer.builder()
			.id(2L)
			.password("Qwe123!@#")
			.email("bbb@naver.com")
			.name("박개발")
			.viewCount(200L)
			.point(0L)
			.build();

		Freelancer freelancer2 = Freelancer.builder()
			.id(3L)
			.password("Qwe123!@#")
			.email("ccc@naver.com")
			.name("이개발")
			.viewCount(100L)
			.point(0L)
			.build();

		return List.of(freelancer, freelancer1, freelancer2);
	}

	public static List<FreelancerResponse> getFreelancerResponseList() {

		FreelancerResponse freelancer1 = FreelancerResponse.builder()
			.id(1L)
			.email("aaa@naver.com")
			.name("김개발")
			.viewCount(0L)
			.createdAt(LocalDateTime.now())
			.build();

		FreelancerResponse freelancer2 = FreelancerResponse.builder()
			.id(2L)
			.email("bbb@naver.com")
			.name("박개발")
			.viewCount(200L)
			.createdAt(LocalDateTime.of(2024, 9, 1, 0, 0, 0))
			.build();

		FreelancerResponse freelancer3 = FreelancerResponse.builder()
			.id(3L)
			.email("ccc@naver.com")
			.name("이개발")
			.viewCount(100L)
			.createdAt(LocalDateTime.of(2024, 9, 9, 0, 0, 0))
			.build();

		return List.of(freelancer1, freelancer2, freelancer3);
	}

}
