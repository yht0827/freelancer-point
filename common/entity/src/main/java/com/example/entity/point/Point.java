package com.example.entity.point;

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
@Table(name = "point")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Point extends BaseTimeEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "order_id")
	private String orderId;

	@Column(name = "pay_type")
	private String payType;

	@Column
	private Long amount;

	@Column(name = "member_id")
	private Long memberId;

	@Builder
	public Point(Long id, String orderId, String payType, Long amount, Long memberId) {
		this.id = id;
		this.orderId = orderId;
		this.payType = payType;
		this.amount = amount;
		this.memberId = memberId;
	}
}
