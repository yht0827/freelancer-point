package com.example.service;

import com.example.entity.freelancer.Freelancer;
import com.example.entity.point.Point;

public interface PointService {

	void pay(Freelancer freelancer, final Point point);
}
