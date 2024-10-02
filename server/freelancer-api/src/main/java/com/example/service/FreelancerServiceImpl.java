package com.example.service;

import static com.example.CodeEnum.*;

import org.apache.commons.lang3.StringUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.CustomException;
import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.FreelancerRepository;
import com.example.repository.freelancer.dto.response.FreelancerDetailResponse;
import com.example.repository.freelancer.dto.response.FreelancerResponse;
import com.example.repository.freelancer.dto.sort.FreelancerOrderRequest;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class FreelancerServiceImpl implements FreelancerService {

	private final FreelancerRepository freelancerRepository;

	@Transactional(readOnly = true)
	public Freelancer getOne(final Long id) {
		return freelancerRepository.findById(id)
			.orElseThrow(() -> new CustomException(NO_FREELANCER));
	}

	@Transactional(readOnly = true)
	public Page<FreelancerResponse> getList(final FreelancerOrderRequest request, final Pageable pageable) {
		return freelancerRepository.findAllByOrderCondition(request, pageable);
	}

	@Transactional
	public FreelancerDetailResponse getDetail(
		final Long id, final HttpServletRequest req, final HttpServletResponse res) {
		Freelancer freelancer = getOne(id);

		viewCountUpdate(freelancer, req, res);

		return FreelancerDetailResponse.toDto(freelancer);
	}

	private void viewCountUpdate(
		final Freelancer freelancer, final HttpServletRequest req, final HttpServletResponse res) {

		Long id = freelancer.getId();

		Cookie[] cookies = req.getCookies();
		Cookie freelancerCookie = null;

		if (cookies != null) {
			for (Cookie cookie : cookies) {
				if (StringUtils.equals(cookie.getName(), "freelancerView")) {
					freelancerCookie = cookie;
				}
			}
		}

		if (freelancerCookie != null) {
			if (!freelancerCookie.getValue().contains("[" + id.toString() + "]")) {
				freelancer.updateViewCount();
				freelancerCookie.setValue(freelancerCookie.getValue() + "_[" + id + "]");
				freelancerCookie.setPath("/");
				freelancerCookie.setMaxAge(60 * 60 * 24);
				res.addCookie(freelancerCookie);
			}
		} else {
			freelancer.updateViewCount();
			Cookie newCookie = new Cookie("freelancerView", "[" + id + "]");
			newCookie.setPath("/");
			newCookie.setMaxAge(60 * 60 * 24);
			res.addCookie(newCookie);
		}
	}
}
