package com.hmiexam.examresultsystem.helper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.hmiexam.examresultsystem.entity.ExamQuestion;

public class FileUploadProcessor {

	private MultipartFile file;
	private int matriculationNo;
	private List<ExamQuestion> questions;
	
	public FileUploadProcessor() {
	}

	public FileUploadProcessor(MultipartFile file) {
		super();
		this.file = file;
		matriculationNo = 0;
		questions = new ArrayList<ExamQuestion>();
		processFile();
	}

	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	public int getMatriculationNo() {
		return matriculationNo;
	}

	public void setMatriculationNo(int matriculationNo) {
		this.matriculationNo = matriculationNo;
	}

	public List<ExamQuestion> getQuestions() {
		return questions;
	}

	public void setQuestions(List<ExamQuestion> questions) {
		this.questions = questions;
	}
	
	private void processFile() {
		
		try {
			InputStream inputStream = file.getInputStream();
			BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
			
			String line = reader.readLine();
			ExamQuestion question = new ExamQuestion();
			
			while(line != null) {
				
				if(line.startsWith("Matrikelnummer") || line.startsWith("Enrollment number")) {
					String[] tokens = line.split(":");
					this.matriculationNo = Integer.parseInt(tokens[1].trim());
				} else if(line.startsWith("Frage")) {
					question = new ExamQuestion();
					
					String[] tokens = line.split("Frage:+|(?=\\[)|(?=\\d\\))", 4);
					for(int j=0; j<tokens.length; j++) {
						if(j==1) {
							String type = tokens[j].substring(2, 4);
							question.setQuestionType(type);
						} else if(j==2) {
							String qn = tokens[j].substring(3);
							question.setQuestion(qn);
						} else if(j==3) {
							String maxPoints = tokens[j].replaceAll("[^0-9]", "");
							question.setMaxPoints(Integer.parseInt(maxPoints.replaceAll(",", ".").trim()));
						}
					}
				} else if(line.startsWith("Korrekte Anwort")) {
					String[] tokens = line.split(":", 2);
					question.setCorrectAns(tokens[1].trim());
				} else if(line.startsWith("Ihre Antwort")) {
					String[] tokens = line.split(":", 2);
					question.setGivenAns(tokens[1].trim());
				} else if(line.startsWith("Punkte")) {
					String[] tokens = line.split(":", 2);
					String points = tokens[1].trim();
					String[] pointTokens = points.split("/", 2);
					question.setScoredPoints(Integer.parseInt(pointTokens[0].replaceAll(",", ".").trim()));
					
					this.questions.add(question);
				}
				
				line = reader.readLine();
			} 
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
