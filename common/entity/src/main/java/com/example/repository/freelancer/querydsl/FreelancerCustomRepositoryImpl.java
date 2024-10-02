package com.example.repository.freelancer.querydsl;

import static com.example.entity.freelancer.QFreelancer.*;

import java.util.List;
import java.util.Objects;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;
import org.springframework.stereotype.Repository;

import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;
import com.example.repository.freelancer.dto.sort.OrderEnum;
import com.querydsl.core.types.OrderSpecifier;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class FreelancerCustomRepositoryImpl implements FreelancerCustomRepository {

	private final JPAQueryFactory queryFactory;

	@Override
	public Page<FreelancerResponse> findAllByOrderCondition(final FreelancerOrderRequest request,
		final Pageable pageable) {

		List<FreelancerResponse> list = queryFactory.select(
				Projections.constructor(FreelancerResponse.class, freelancer.id, freelancer.email, freelancer.name,
					freelancer.viewCount, freelancer.createdAt))
			.from(freelancer)
			.orderBy(getOrderSpecifier(request))
			.limit(pageable.getPageSize())
			.offset(pageable.getOffset())
			.fetch();

		if (list.isEmpty()) {
			return Page.empty();
		}

		JPAQuery<Long> count = queryFactory
			.select(freelancer.count())
			.from(freelancer);

		return PageableExecutionUtils.getPage(list, pageable, count::fetchOne);
	}

	private OrderSpecifier<?> getOrderSpecifier(final FreelancerOrderRequest request) {

		if (Objects.isNull(request)) {
			return freelancer.id.desc();
		} else if (StringUtils.equals(OrderEnum.NAME.getCondition(), request.orderCondition())) {
			return freelancer.name.asc();
		} else if (StringUtils.equals(OrderEnum.VIEW_COUNT.getCondition(), request.orderCondition())) {
			return freelancer.viewCount.desc();
		} else if (StringUtils.equals(OrderEnum.DATE.getCondition(), request.orderCondition())) {
			return freelancer.createdAt.desc();
		}

		return freelancer.id.desc();
	}
}
