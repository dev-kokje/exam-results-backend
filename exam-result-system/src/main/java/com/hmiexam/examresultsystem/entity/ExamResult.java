package com.hmiexam.examresultsystem.entity;

import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class ExamResult {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name="course_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Course course;
	
	@ManyToOne
	@JoinColumn(name="student_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private Student student;
	
	@Column(name="max_points")
	private int maxPoints;
	
	@Column(name="received_points")
	private int receivedPoints;
	
	@Column(name="pointer")
	private Double pointer;
	
	@Column(name="grade")
	private String grade;
	
	@Column(name="status")
	private String status;
	
	@JsonIgnore
	@OneToMany(mappedBy="exam")
	private List<ExamQuestion> questions;
	
	public ExamResult() {
	
	}

	public ExamResult(Course course, Student student, int maxPoints, int receivedPoints, Double pointer, String grade,
			String status) {
		super();
		this.course = course;
		this.student = student;
		this.maxPoints = maxPoints;
		this.receivedPoints = receivedPoints;
		this.pointer = pointer;
		this.grade = grade;
		this.status = status;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}

	public int getReceivedPoints() {
		return receivedPoints;
	}

	public void setReceivedPoints(int receivedPoints) {
		this.receivedPoints = receivedPoints;
	}

	public Double getPointer() {
		return pointer;
	}

	public void setPointer(Double pointer) {
		this.pointer = pointer;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<ExamQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<ExamQuestion> questions) {
		this.questions = questions;
	}

	@Override
	public String toString() {
		return "ExamResult [id=" + id + ", course=" + course + ", student=" + student + ", maxPoints=" + maxPoints
				+ ", receivedPoints=" + receivedPoints + ", pointer=" + pointer + ", grade=" + grade + ", status="
				+ status + "]";
	}
}
