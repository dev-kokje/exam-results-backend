package com.hmiexam.examresultsystem.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmiexam.examresultsystem.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer> {

	public List<Course> findBySemesterId(int semesterId);
}
