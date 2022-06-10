package com.hmiexam.examresultsystem.service;

import java.util.List;
import java.util.Optional;

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
	
	public Student findByMatriculationNo(int matriculationNo) {
		Optional<Student> student = studentRepository.findByMatriculationNo(matriculationNo);
		
		if(!student.isPresent()) {
			throw new RuntimeException("Student with matriculation no " + matriculationNo + " is not present in database");
		}
		
		return student.get();
	}
	
	public Student save(Student newStudent) {
		Student student = studentRepository.save(newStudent);
		return student;
	}
}
