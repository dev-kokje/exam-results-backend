package com.hmiexam.examresultsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmiexam.examresultsystem.entity.Student;
import com.hmiexam.examresultsystem.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	public List<Student> findAll() {
		return studentRepository.findAll();
	}
	
	public Student save(Student newStudent) {
		Student student = studentRepository.save(newStudent);
		return student;
	}
}
