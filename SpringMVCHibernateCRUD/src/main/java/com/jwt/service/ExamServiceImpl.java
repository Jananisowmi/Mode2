package com.jwt.service;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwt.controller.StudentController;
import com.jwt.dao.ExamDAO;

import com.jwt.model.Exam;
@Service
@Transactional
public class ExamServiceImpl implements ExamService {
@Autowired
private ExamDAO examDAO;
private static final Logger logger = Logger
.getLogger(StudentController.class);

@Override
@Transactional
public void addExam(Exam exam) {
logger.debug("debug:" +new Date()+this.getClass()+ " addExam()");
logger.debug("debug:" +new Date()+this.getClass()+ " " + exam.getMi() +" "+exam.getSid() + " " + exam.getSubName() + " " + exam.getMarks());
examDAO.addExam(exam);
examDAO.updateStudentFinalScore(exam.getSid());
}

//
//@Transactional
//public List<Exam> getAllExams() {
//return examDAO.getAllExams();
//}

@Transactional
public void deleteExam(int mi) {
examDAO.deleteExam(mi);
examDAO.updateStudentFinalScore(mi);

}

public List<Exam> getExamsBySid(int sid) {
return examDAO.getExamsBySid(sid);
}

public Exam updateExam(Exam exam) {
logger.debug(new Date() +"  : "+ this.getClass() + "Method name : updateExam()");
logger.debug(new Date() +"  : "+ this.getClass() + " ExamId "+ exam.getMi()+" SID "+ exam.getSid()+" subject "+ exam.getSubName());
exam = examDAO.updateExam(exam);
examDAO.updateStudentFinalScore(exam.getSid());
return exam;
}

public void setExamDao(ExamDAO examDao) {
this.examDAO = examDao;
}
@Override
public Exam getExamById(int mi) {
return examDAO.getExamById(mi);
}

//public void updateStudentFinalScore(int sid) {
//// get final score for student
//double avgMarks = examDAO.getAvgMarks(sid);
//logger.debug(new Date() +"  : "+ this.getClass() + " Method name : updateStudentFinalScore() getAvgMarks("+sid+") = " + avgMarks);
//logger.debug(new Date() +"  : "+ this.getClass() + " Method name : updateStudentFinalScore() updating finalScore for "+sid);
//// update final score
//// studentService.updateFinalScore(sid, avgMarks);
//logger.debug(new Date() +"  : "+ this.getClass() + "Method name : updateStudentFinalScore("+ sid+")  updateFinalScore()");
///*
//
//
//Student student = studentService.getStudentById(sid);
//logger.debug(new Date() +"  : "+ this.getClass() + "Method name : updateStudentFinalScore() getStudentById()");
//// logger.debug(new Date() +"  : "+ this.getClass() + " ExamId "+ exam.getEid()+" SID "+ exam.getSid()+" subject "+ exam.getSubject());
//student.setFinalScore(finalScore);
//student = studentService.updateStudent(student);
//logger.debug(new Date() +"  : "+ this.getClass() + "Method name : updateStudentFinalScore("+ sid+")  FinalScore is ..." + student.getFinalScore());
//logger.debug(new Date() +"  : "+ this.getClass() + "Method name : updateStudentFinalScore("+ sid+")  redirecting to edit method ..." );*/
//}
//
//@Override
//public List<Exam> getAllExams() {
//	// TODO Auto-generated method stub
//	return null;
//}

}
