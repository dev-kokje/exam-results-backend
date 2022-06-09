package com.hmiexam.examresultsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmiexam.examresultsystem.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer> {

}
