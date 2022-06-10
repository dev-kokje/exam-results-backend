package com.hmiexam.examresultsystem.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.hmiexam.examresultsystem.entity.Student;
import com.hmiexam.examresultsystem.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	private StudentService studentService;
	
	@GetMapping("/students")
	public List<Student> findAll() {
		return studentService.findAll();
	}
	
	@GetMapping("/students/{matriculationNo}")
	public Student findByMatriculationNo(@PathVariable int matriculationNo) {
		return studentService.findByMatriculationNo(matriculationNo);
	}
	
	@PostMapping("/students")
	public ResponseEntity<Student> save(@RequestBody Student student) {
		Student addedStudent = studentService.save(student);
		return new ResponseEntity<Student>(addedStudent, HttpStatus.CREATED);
	}
}
