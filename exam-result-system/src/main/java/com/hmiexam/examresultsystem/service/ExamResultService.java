package com.hmiexam.examresultsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmiexam.examresultsystem.entity.ExamResult;
import com.hmiexam.examresultsystem.repository.ExamResultRepository;

@Service
public class ExamResultService {

	@Autowired
	private ExamResultRepository examResultRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentService studentService;
	
	public List<ExamResult> findAll() {
		return examResultRepository.findAll();
	}
	
	
}
