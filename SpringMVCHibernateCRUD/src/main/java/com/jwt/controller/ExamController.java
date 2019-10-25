	package com.jwt.controller;
	
	import java.io.IOException;
	import java.util.HashMap;
	import java.util.List;
	import java.util.Map;
	
	import javax.servlet.http.HttpServletRequest;
	
	import org.apache.log4j.Logger;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.http.HttpRequest;
	import org.springframework.stereotype.Controller;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.servlet.ModelAndView;
	
	import com.jwt.model.Exam;
	import com.jwt.service.ExamService;
	
	
	@Controller
	public class ExamController {
	
	private static final Logger logger = Logger
	.getLogger(ExamController.class);
	
	public ExamController() {
	logger.info("ExamController");
	System.out.println("ExamController()");
	}
	
	@Autowired
	private  ExamService examService;
	
	
	
	@RequestMapping(value = "/newExam", method = RequestMethod.GET)
	public ModelAndView newContact(ModelAndView model, HttpServletRequest request) {
		logger.debug("entering into method");
	Exam exam = new Exam();
	// exam.setMi(Integer.parseInt(request.getParameter("id")));
	int sid = Integer.parseInt(request.getParameter("sid"));
	String name = request.getParameter("Name");
	exam.setSid(sid);
	model.addObject("sid", sid);
	model.addObject("name", name);
	model.addObject("exam", exam);
	model.setViewName("ExamForm");
	return model;
	}
	
	@RequestMapping(value = "/showExam", method = RequestMethod.GET)
	public ModelAndView showExam(ModelAndView model,HttpServletRequest request) {
	logger.info("Entering into the newExam method..");
	logger.info("Calling the exam service and its getAllExams..");
	Exam exam = new Exam();
	int sid = Integer.parseInt(request.getParameter("sid"));
	List<Exam> examList = examService.getExamsBySid(sid);
	
	
	exam.setSid(sid);
	model.addObject("exam", exam);
	model.addObject("sid", sid);
	model.addObject("examList", examList);
	model.setViewName("ExamShow");
	return model;
	}
	
	@RequestMapping(value = "/saveExam", method = RequestMethod.POST)
	public ModelAndView saveExam(@ModelAttribute Exam exam) {
	System.out.println(exam.getSubName());
	
	examService.addExam(exam);
	if (exam.getSid() == 0) {
	examService.addExam(exam);
	} else {
	examService.updateExam(exam);
	}
	return new ModelAndView("redirect:/exam/showExam?sid="+exam.getSid());
	}
	
	@RequestMapping(value = "/deleteExam", method = RequestMethod.GET)
	public ModelAndView deleteExam(HttpServletRequest request) {
	int id = Integer.parseInt(request.getParameter("mi"));
	examService.deleteExam(id);
	return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value = "/editExam", method = RequestMethod.GET)
	public ModelAndView editContact(HttpServletRequest request,ModelAndView model) {
	int mi = Integer.parseInt(request.getParameter("mi"));
	Exam exam = examService.getExamById(mi);
	/*System.out.println(exam.getSubName());
	System.out.println(exam.getMarks());*/
	model.addObject("exam", exam);
	model.setViewName("ExamShow");
	
	return model;
	}
	@ModelAttribute("subjectList")
	  public Map<String, String> getCountryList() {
	     Map<String, String> subjectList = new HashMap<String, String>();
	     subjectList.put("T", "Tamil");
	     subjectList.put("S", "Social");
	     subjectList.put("SC", "Science");
	     subjectList.put("M", "Malayalam");
	     return subjectList;
	  }
	
	
	
	
	}
