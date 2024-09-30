package com.example.freelancerapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example")
public class FreelancerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(FreelancerApiApplication.class, args);
	}

}
