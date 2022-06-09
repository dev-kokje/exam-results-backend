package com.hmiexam.examresultsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {

	@Id
	@Column(name="matriculation_no")
	private int matriculationNo;
	
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
