package com.example.freelancerapi;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.FreelancerRepository;

@SpringBootTest
public class FreelancerControllerTest {

	@Autowired
	private FreelancerRepository freelancerRepository;

	@BeforeEach
	public void insert() {
		Freelancer freelancer = Freelancer.builder()
			.id(1L)
			.password("Qwe123!@#")
			.email("aaa@naver.com")
			.viewCount(0L)
			.point(0L)
			.build();

		freelancerRepository.save(freelancer);
	}

	@AfterEach
	public void delete() {
		freelancerRepository.deleteAll();
	}

	@Test
	@DisplayName("정보")
	public void test() {

		List<Freelancer> freelancerList = freelancerRepository.findAll();

		for (Freelancer freelancer : freelancerList) {
			System.out.println(freelancer.getEmail());
		}

	}

}
