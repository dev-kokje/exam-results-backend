package com.hmiexam.examresultsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hmiexam.examresultsystem.entity.FileInfo;

public interface FileInfoRepository extends JpaRepository<FileInfo, Integer> {

}
