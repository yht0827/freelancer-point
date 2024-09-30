package com.example.repository.freelancer;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.freelancer.Freelancer;

public interface FreelancerRepository extends JpaRepository<Freelancer, Long>, FreelancerCustomRepository {
}
