package com.example.entity.freelancer;

import com.example.entity.base.BaseTimeEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "freelancer")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Freelancer extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false, unique = true)
	private String email;

	@Column
	private String name;

	@Column
	private String password;

	@Column(name = "view_count")
	private Long viewCount;

	@Column
	private Long point;

	@Builder
	public Freelancer(Long id, String email, String name, String password, Long viewCount, Long point) {
		this.id = id;
		this.email = email;
		this.name = name;
		this.password = password;
		this.viewCount = viewCount;
		this.point = point;
	}

	public void updateViewCount() {
		this.viewCount = this.viewCount + 1;
	}

	@Override
	public String toString() {
		return "Freelancer{" +
			"id=" + id +
			", email='" + email + '\'' +
			", name='" + name + '\'' +
			", password='" + password + '\'' +
			", viewCount=" + viewCount +
			", point=" + point +
			", created=" + super.getCreatedAt() +
			'}';
	}
}
