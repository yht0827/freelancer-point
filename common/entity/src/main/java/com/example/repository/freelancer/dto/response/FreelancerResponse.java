package com.example.repository.freelancer.dto.response;

import java.time.LocalDateTime;

import lombok.Builder;

@Builder
public record FreelancerResponse(Long id, String email, String name, Long viewCount, LocalDateTime createdAt) {
}
