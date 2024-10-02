package com.example.freelancerapi;

import static com.example.CodeEnum.*;
import static org.assertj.core.api.AssertionsForClassTypes.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.CustomException;
import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.FreelancerRepository;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DisplayName("프리랜서 Repository 테스트")
public class FreelancerRepositoryTest {

	@Autowired
	private FreelancerRepository freelancerRepository;

	private static Long FREELANCER_ID;

	@BeforeEach
	public void insert() {
		FREELANCER_ID = freelancerRepository.saveAll(FreelancerTestDto.getFreelancerList()).getFirst().getId();
	}

	@AfterEach
	public void delete() {
		freelancerRepository.deleteAll();
	}

	@Test
	@DisplayName("freelancer 리스트 가나다 순 조회")
	public void 가나다순_조회() {
		Page<FreelancerResponse> list = freelancerRepository.findAllByOrderCondition(new FreelancerOrderRequest("name"),
			Pageable.ofSize(20));

		assertThat(list.getContent().getFirst().name()).isEqualTo("김개발");
	}

	@Test
	@DisplayName("freelancer 리스트 조회수 순 조회")
	public void 조회수_조회() {
		Page<FreelancerResponse> list = freelancerRepository.findAllByOrderCondition(
			new FreelancerOrderRequest("viewCount"),
			Pageable.ofSize(20));

		assertThat(list.getContent().getFirst().name()).isEqualTo("박개발");
	}

	@Test
	@DisplayName("freelancer 리스트 등록 순 조회")
	public void 등록순_조회() {
		Page<FreelancerResponse> list = freelancerRepository.findAllByOrderCondition(
			new FreelancerOrderRequest("date"),
			Pageable.ofSize(20));

		assertThat(list.getContent().getFirst().name()).isEqualTo("이개발");
	}

	@Test
	@DisplayName("freelancer 상세 조회")
	public void 상세_조회() {
		Freelancer freelancer = freelancerRepository.findById(FREELANCER_ID)
			.orElseThrow(() -> new CustomException(NO_FREELANCER));

		assertThat(freelancer.getName()).isEqualTo("김개발");
	}

	@Test
	@DisplayName("freelancer 조회수 증가")
	public void 조회수_증가() {
		Freelancer freelancer = freelancerRepository.findById(FREELANCER_ID)
			.orElseThrow(() -> new CustomException(NO_FREELANCER));

		freelancer.updateViewCount();

		assertThat(freelancer.getViewCount()).isEqualTo(1L);
	}
}
