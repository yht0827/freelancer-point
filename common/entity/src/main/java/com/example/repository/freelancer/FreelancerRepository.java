package com.example.repository.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.freelancer.Freelancer;
import com.example.repository.freelancer.querydsl.FreelancerCustomRepository;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long>, FreelancerCustomRepository {
}
