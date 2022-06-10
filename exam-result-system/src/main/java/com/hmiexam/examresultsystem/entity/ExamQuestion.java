package com.hmiexam.examresultsystem.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="ExamQuestions")
public class ExamQuestion {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="question")
	private String question;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="exam_id")
	@OnDelete(action=OnDeleteAction.CASCADE)
	private ExamResult exam;
	
	@Column(name="question_type")
	private String questionType;
	
	@Column(name="correct_ans")
	private String correctAns;
	
	@Column(name="given_ans")
	private String givenAns;
	
	@Column(name="max_points")
	private int maxPoints;
	
	@Column(name="scored_points")
	private int scoredPoints;
	
	public ExamQuestion() {
	}

	public ExamQuestion(String question, ExamResult exam, String questionType, String correctAns, String givenAns,
			int maxPoints, int scoredPoints) {
		super();
		this.question = question;
		this.exam = exam;
		this.questionType = questionType;
		this.correctAns = correctAns;
		this.givenAns = givenAns;
		this.maxPoints = maxPoints;
		this.scoredPoints = scoredPoints;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public ExamResult getExam() {
		return exam;
	}

	public void setExam(ExamResult exam) {
		this.exam = exam;
	}

	public String getQuestionType() {
		return questionType;
	}

	public void setQuestionType(String questionType) {
		this.questionType = questionType;
	}

	public String getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}

	public String getGivenAns() {
		return givenAns;
	}

	public void setGivenAns(String givenAns) {
		this.givenAns = givenAns;
	}

	public int getMaxPoints() {
		return maxPoints;
	}

	public void setMaxPoints(int maxPoints) {
		this.maxPoints = maxPoints;
	}

	public int getScoredPoints() {
		return scoredPoints;
	}

	public void setScoredPoints(int scoredPoints) {
		this.scoredPoints = scoredPoints;
	}

	@Override
	public String toString() {
		return "ExamQuestion [id=" + id + ", question=" + question + ", exam=" + exam + ", questionType=" + questionType
				+ ", correctAns=" + correctAns + ", givenAns=" + givenAns + ", maxPoints=" + maxPoints
				+ ", scoredPoints=" + scoredPoints + "]";
	} 
}
