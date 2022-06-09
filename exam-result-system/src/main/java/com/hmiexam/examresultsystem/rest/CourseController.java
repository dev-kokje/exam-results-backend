package com.hmiexam.examresultsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hmiexam.examresultsystem.entity.Course;
import com.hmiexam.examresultsystem.service.CourseService;

@RestController
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@GetMapping("/courses")
	public List<Course> findAll() {
		return courseService.findAll();
	}
	
	@GetMapping("/courses/{id}")
	public Course findById(@PathVariable int id) {
		return courseService.findById(id);
	}
	
	@DeleteMapping("/courses/{id}")
	public void deleteCourse(@PathVariable int id) {
		courseService.deleteCourseById(id);
	}
}
