package com.example.repository.freelancer.dto.response;

import com.example.entity.freelancer.Freelancer;

import lombok.Builder;

@Builder
public record FreelancerDetailResponse(
	Long id, String email, String name, Long viewCount, Long point) {

	public static FreelancerDetailResponse toDto(final Freelancer freelancer) {
		return FreelancerDetailResponse.builder()
			.id(freelancer.getId())
			.email(freelancer.getEmail())
			.name(freelancer.getName())
			.viewCount(freelancer.getViewCount())
			.point(freelancer.getPoint())
			.build();
	}

}
