package com.example.freelancerapi;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;

import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.FreelancerRepository;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.service.FreelancerServiceImpl;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@DisplayName("프리랜서 서비스 테스트")
public class FreelancerServiceTest {

	@Mock
	private FreelancerRepository freelancerRepository;

	@InjectMocks
	private FreelancerServiceImpl freelancerService;

	@Mock
	private HttpServletRequest request;

	@Mock
	private HttpServletResponse response;

	public FreelancerServiceTest() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	@DisplayName("getList() 메소드 테스트")
	public void getFreelancerList() {
		// given
		Page<FreelancerResponse> freelancerResponsePage = PageableExecutionUtils.getPage(
			FreelancerTestDto.getFreelancerResponseList(), PageRequest.of(0, 10), () -> 1L);

		// when
		when(freelancerRepository.findAllByOrderCondition(any(), any())).thenReturn(freelancerResponsePage);

		// then
		assertThat(freelancerService.getList(any(), any()).getContent().getFirst().id()).isEqualTo(1L);
	}

	@Test
	@DisplayName("getDetail() 메소드 테스트")
	public void getFreelancerDetail() {
		// given
		Freelancer freelancer = Freelancer.builder()
			.id(1L)
			.email("aaa@naver.com")
			.name("임개발")
			.viewCount(20L)
			.point(1000L)
			.build();

		// when
		when(freelancerRepository.findById(1L)).thenReturn(Optional.of(freelancer));

		// then
		assertThat(freelancerService.getDetail(1L, request, response).id()).isEqualTo(1L);
	}

}
