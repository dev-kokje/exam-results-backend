package com.hmiexam.examresultsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmiexam.examresultsystem.entity.ExamQuestion;

public interface ExamQuestionRepository extends JpaRepository<ExamQuestion, Integer> {

}
