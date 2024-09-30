package com.example.repository.freelancer;

import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FreelancerCustomRepositoryImpl implements FreelancerCustomRepository {

	private final JPAQueryFactory queryFactory;
}
