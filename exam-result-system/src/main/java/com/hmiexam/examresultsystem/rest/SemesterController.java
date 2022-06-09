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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.hmiexam.examresultsystem.entity.Course;
import com.hmiexam.examresultsystem.entity.Semester;
import com.hmiexam.examresultsystem.repository.CourseRepository;
import com.hmiexam.examresultsystem.repository.SemesterRepository;
import com.hmiexam.examresultsystem.service.CourseService;
import com.hmiexam.examresultsystem.service.SemesterService;

@RestController
public class SemesterController {

	@Autowired
	private SemesterService semesterService;
	
	@Autowired
	private CourseService courseService;
	
	@GetMapping("/semesters")
	public List<Semester> getAll() {
		return semesterService.findAll();
	}
	
	@GetMapping("/semesters/{id}")
	public Semester getById(@PathVariable int id) {
		return semesterService.findById(id);
	}
	
	@PostMapping("/semesters")
	public ResponseEntity<Semester> save(@RequestBody Semester semester) {
		Semester savedSemester = semesterService.save(semester);
		return new ResponseEntity<Semester>(savedSemester, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/semesters/{id}")
	public void delete(@PathVariable int id) {
		semesterService.deleteById(id);
	}
	
	@GetMapping("/semesters/{id}/courses") 
	public List<Course> findCourseBySemesterId(@PathVariable int id) {
		return courseService.findBySemesterId(id);
	}
	
	@PostMapping("/semesters/{semesterId}/courses")
	public ResponseEntity<Course> saveCourse(@PathVariable int semesterId, @RequestBody Course newCourse) {
		Semester semester = semesterService.findById(semesterId);
		newCourse.setSemester(semester);
		Course addedCourse = courseService.save(newCourse);
		return new ResponseEntity<Course>(addedCourse, HttpStatus.CREATED);
	}
}
