package com.hmiexam.examresultsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmiexam.examresultsystem.entity.Course;
import com.hmiexam.examresultsystem.repository.CourseRepository;

@Service
public class CourseService {

	@Autowired
	private CourseRepository repository;
	
	public List<Course> findAll() {
		return repository.findAll();
	}
	
	public Course findById(int courseId) {
		Optional<Course> course = repository.findById(courseId);
		
		if(!course.isPresent()) {
			throw new RuntimeException("Course with id " + courseId + " not found in database.");
		}
		
		return course.get();
	}
	
	public Course save(Course course) {
		Course addedCourse = repository.save(course);
		return addedCourse;
	}
	
	public void deleteCourseById(int courseId) {
		Course course = this.findById(courseId);
		repository.delete(course);
	}
	
	public List<Course> findBySemesterId(int semesterId) {
		List<Course> courses = repository.findBySemesterId(semesterId);
		return courses;
	}
}
