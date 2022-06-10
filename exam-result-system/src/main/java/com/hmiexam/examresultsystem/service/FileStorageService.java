package com.hmiexam.examresultsystem.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.hmiexam.examresultsystem.entity.ExamQuestion;
import com.hmiexam.examresultsystem.helper.FileUploadProcessor;

@Service
public class FileStorageService {

	private final Path root = Paths.get("uploads");
	
	public void init() {
		try {
			if(!Files.exists(root)) {
				Files.createDirectory(root);
			}
		} catch(IOException e) {
			throw new RuntimeException("Could not initialize folder for file upload");
		}
	}
	
}
