package com.hmiexam.examresultsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmiexam.examresultsystem.entity.ExamResult;

public interface ExamResultRepository extends JpaRepository<ExamResult, Integer> {

}
