package com.hmiexam.examresultsystem.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Students")
public class Student {

	@Id
	@Column(name="matriculation_no")
	private int matriculationNo;
	
	@JsonIgnore
	@OneToMany(mappedBy="student")
	private Set<ExamResult> examResults;
	
	public Student() {
	}

	public Student(int matriculationNo) {
		super();
		this.matriculationNo = matriculationNo;
	}

	public int getMatriculationNo() {
		return matriculationNo;
	}

	public void setMatriculationNo(int matriculationNo) {
		this.matriculationNo = matriculationNo;
	}

	@Override
	public String toString() {
		return "Student [matriculationNo=" + matriculationNo + "]";
	}
}
