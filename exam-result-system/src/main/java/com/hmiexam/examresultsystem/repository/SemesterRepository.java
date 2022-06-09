package com.hmiexam.examresultsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmiexam.examresultsystem.entity.Semester;

public interface SemesterRepository extends JpaRepository<Semester, Integer> {

}
