package com.hmiexam.examresultsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hmiexam.examresultsystem.entity.Semester;
import com.hmiexam.examresultsystem.repository.SemesterRepository;

@Service
public class SemesterService {

	@Autowired
	private SemesterRepository semesterRepository;
	
	public List<Semester> findAll() {
		return semesterRepository.findAll();
	}
	
	public Semester findById(int id) {
		Optional<Semester> semester = semesterRepository.findById(id);
		
		if(!semester.isPresent()) {
			throw new RuntimeException("Semester with id " + id + " not found in database.");
		}
		
		return semester.get();
	}
	
	public Semester save(Semester semester) {
		Semester savedSemester = semesterRepository.save(semester);
		return savedSemester;
	}
	
	public void deleteById(int id) {
		Semester semester = this.findById(id);
		semesterRepository.delete(semester);
	}
}
