package com.jwt.service;

import java.util.List;

import com.jwt.model.Exam;

public interface ExamService {
public void addExam(Exam exam);

//public List<Exam> getAllExams();

public void deleteExam(int mi);
public Exam getExamById(int mi);
public List<Exam> getExamsBySid(int sid);

public Exam updateExam(Exam exam);
//public void updateStudentFinalScore(int sid);



}

