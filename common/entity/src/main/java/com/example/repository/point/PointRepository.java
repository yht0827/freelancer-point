package com.example.repository.point;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.point.Point;

public interface PointRepository extends JpaRepository<Point, Long> {
}
