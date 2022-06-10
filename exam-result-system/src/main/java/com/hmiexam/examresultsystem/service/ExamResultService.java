package com.hmiexam.examresultsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hmiexam.examresultsystem.entity.Course;
import com.hmiexam.examresultsystem.entity.ExamQuestion;
import com.hmiexam.examresultsystem.entity.ExamResult;
import com.hmiexam.examresultsystem.entity.Student;
import com.hmiexam.examresultsystem.helper.FileUploadProcessor;
import com.hmiexam.examresultsystem.repository.ExamQuestionRepository;
import com.hmiexam.examresultsystem.repository.ExamResultRepository;

@Service
public class ExamResultService {

	@Autowired
	private ExamResultRepository examResultRepository;
	
	@Autowired
	private CourseService courseService;
	
	@Autowired
	private StudentService studentService;
	
	@Autowired
	private ExamQuestionRepository examQuestionRepository;
	
	public List<ExamResult> findAll() {
		return examResultRepository.findAll();
	}
	
	public ExamResult save(int courseId, MultipartFile file) {
		
		FileUploadProcessor fileProcessor = new FileUploadProcessor(file);
		
		// Find student using the matriculation no in file
		int matriculationNo = fileProcessor.getMatriculationNo();
		Student student = null;
		try {
			student = studentService.findByMatriculationNo(matriculationNo);
		} catch(RuntimeException ex) {
			ex.printStackTrace();
		}
		
		if(student == null) {
			student = new Student(matriculationNo);
			student = studentService.save(student);
		}
		
		// Find course from the given course id
		Course course = null;
		try {
			course = courseService.findById(courseId);
		} catch(RuntimeException ex) {
			ex.printStackTrace();
		}
		
		// Create new ExamResult object
		ExamResult examResult = new ExamResult();
		examResult.setCourse(course);
		examResult.setStudent(student);
		
		// Insert all questions data
		List<ExamQuestion> questions = fileProcessor.getQuestions();
		int examMaxPoints=0;
		int examReceivedPoints=0;
		for(ExamQuestion question: questions) {
			question.setExam(examResult);
			examMaxPoints += question.getMaxPoints();
			examReceivedPoints += question.getScoredPoints();
			
			examQuestionRepository.save(question);
		}
		
		examResult.setMaxPoints(examMaxPoints);
		examResult.setReceivedPoints(examReceivedPoints);
		
		/*
		 * Implement Exam Result Logic later..
		 */
		
		/*
		 * examResult.setPointer(null); 
		 * examResult.setGrade(null);
		 * examResult.setStatus(null);
		 */
		
		ExamResult savedExamResult = examResultRepository.save(examResult);
		
		return savedExamResult;
	}
	
}
