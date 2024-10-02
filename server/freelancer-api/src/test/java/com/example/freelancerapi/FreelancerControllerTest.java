package com.example.freelancerapi;

import static org.mockito.Mockito.*;
import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.web.servlet.MockMvc;

import com.example.application.FreelancerApplicationImpl;
import com.example.controller.FreelancerController;
import com.example.repository.freelancer.dto.response.FreelancerDetailResponse;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.fasterxml.jackson.databind.ObjectMapper;

@DisplayName("프리랜서 컨트롤러 테스트")
@WebMvcTest(controllers = FreelancerController.class)
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class FreelancerControllerTest {

	@Autowired
	private MockMvc mockMvc;

	private ObjectMapper objectMapper;

	@BeforeEach
	public void setUp() {
		objectMapper = new ObjectMapper();
	}

	@MockBean
	private FreelancerApplicationImpl freelancerApplication;

	@Test
	@DisplayName("프리랜서 리스트 api")
	public void 프리랜서_리스트_조회() throws Exception {
		// given
		Page<FreelancerResponse> freelancerResponsePage = PageableExecutionUtils.getPage(
			FreelancerTestDto.getFreelancerResponseList(), PageRequest.of(0, 10), () -> 1L);

		// when
		when(freelancerApplication.getList(any(), any()))
			.thenReturn(freelancerResponsePage);

		// then
		mockMvc.perform(get("/api/v1/freelancer/list?orderCondition=name"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.content").isArray())
			.andExpect(jsonPath("$.content[0].id").value(1)) // 첫 번째 아티클 ID 검증
			.andExpect(jsonPath("$.content[0].email").value("aaa@naver.com"))
			.andExpect(jsonPath("$.content[0].name").value("김개발"))
			.andExpect(jsonPath("$.content[1].id").value(2)) // 첫 번째 아티클 ID 검증
			.andExpect(jsonPath("$.content[1].email").value("bbb@naver.com"))
			.andExpect(jsonPath("$.content[1].name").value("박개발"))
			.andExpect(jsonPath("$.page.totalElements").value(3)) // 총 요소 수 검증
			.andExpect(jsonPath("$.page.totalPages").value(1));
	}

	@Test
	@DisplayName("프리랜서 상세 조회 api")
	public void 프리랜서_상세_조회() throws Exception {
		// given
		FreelancerDetailResponse freelancerDetailResponse = FreelancerDetailResponse.builder()
			.id(1L)
			.email("aaa@naver.com")
			.name("임개발")
			.viewCount(20L)
			.point(1000L)
			.build();

		// when
		when(freelancerApplication.getDetail(any(), any(), any()))
			.thenReturn(freelancerDetailResponse);

		// then
		mockMvc.perform(get("/api/v1/freelancer/{id}", 1L))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.info").isMap())
			.andExpect(jsonPath("$.info.id").value(1))
			.andExpect(jsonPath("$.info.email").value("aaa@naver.com"))
			.andExpect(jsonPath("$.info.name").value("임개발"));
	}
}
