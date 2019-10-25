	package com.jwt.dao;
	
	import java.util.ArrayList;
	import java.util.Date;
	import java.util.List;
	
	import org.apache.log4j.Logger;
	import org.hibernate.Criteria;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.criterion.Criterion;
	import org.hibernate.criterion.Projection;
	import org.hibernate.criterion.Projections;
	import org.hibernate.criterion.Restrictions;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	
	import com.jwt.controller.StudentController;
	import com.jwt.model.Exam;
	import com.jwt.model.Student;
	@Repository
	public class ExamDAOImpl implements ExamDAO {
	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger = Logger
	.getLogger(StudentController.class);
	
	public void addExam(Exam exam) {
	sessionFactory.getCurrentSession().saveOrUpdate(exam);
	}
	@SuppressWarnings("unchecked")
	public List<Exam> getAllExams() {
	
	return sessionFactory.getCurrentSession().createQuery("from Exam")
	.list();
	}
	
	@Override
	public void deleteExam(int mi) {
	Exam exam = (Exam) sessionFactory.getCurrentSession().load(
	Exam.class, mi);
	if (null != exam) {
	this.sessionFactory.getCurrentSession().delete(exam);
	}
	
	}
	
	public List<Exam> getExamsBySid(int sid) {
//	Session s = sessionFactory.getCurrentSession();
//	List<Exam> examList = new ArrayList<Exam>();
//	Criteria cr = s.createCriteria(Exam.class);
//	Criterion crId = Restrictions.eq("sid", sid);
//	cr.add(crId);
//	List list = cr.list();
//	for(Object obj : list) {
//	Exam exam = (Exam)obj;
//	examList.add(exam);
//	}
//	return examList;
//	}
		return sessionFactory.getCurrentSession().createQuery("from Exam where sid="+sid)
				.list();
	}
	
	@Override
	public Exam updateExam(Exam exam) {
	logger.debug("debug:" +new Date()+this.getClass()+ " updateExam()");
	logger.debug("debug:" +new Date()+this.getClass()+ " " + exam.getMi() +" "+exam.getSid() + " " + exam.getSubName() + " " + exam.getMarks());
	sessionFactory.getCurrentSession().update(exam);
	
	return exam;
	}
	
	@Override
	public Exam getExamById(int mi) {
	logger.debug("debug:" +new Date()+this.getClass()+ " getExamById("+mi+")");
	Exam exam = (Exam) sessionFactory.getCurrentSession().get(
	Exam.class, mi);
	System.out.println(exam.toString()); 
	return exam;
	}
	
////	@Override
////	public double getAvgMarks(int sid) {
////	// select avg(mark) from exam where sid = sid;
////	//Logger.debug(new Date() +"  : "+ this.getClass() + " Method name : getAvgMarks("+ sid+") sid  " + sid);
////	Criteria cr =  sessionFactory.getCurrentSession().createCriteria(Exam.class);
////	Projection p = Projections.avg("marks");
////	cr.setProjection(p);
////	Criterion crId = Restrictions.eq("sid", sid);
////	cr.add(crId);
////	double avgMarks = (double)cr.uniqueResult();
////	// Logger.debug(new Date() +"  : "+ this.getClass() + " Method name : getAvgMarks("+ sid+") finalScore is  " + avgMarks);
////	return avgMarks;
////	}
////	
////	@Override
////	public Student getStudentById(int id) {
////	//logger.debug(new Date() +"  : "+ this.getClass() + " Method name : getStudentById("+id+") ");
////	return (Student) sessionFactory.getCurrentSession().get(
////	Student.class, id);
////	}
//	
	@Override
	public void updateStudentFinalScore(int sid) {
		List list=sessionFactory.getCurrentSession().createQuery("from Student where id="+sid).list();
		Student st=(Student) list.get(0);
		list=sessionFactory.getCurrentSession().createQuery("select avg(mark) from Exam where sid="+sid).list();
		if(list.get(0)!=null)
			st.setFinalScore((double)list.get(0));
			else
				st.setFinalScore(0.0f);
		 sessionFactory.getCurrentSession().update(st);
	}
//	double marks = getAvgMarks(sid) ;
//	Student student = getStudentById(sid);
//	student.setFinalScore(marks);
	//Logger.debug(new Date() +"  : "+ this.getClass() + " Method name : updateStudentFinalScore("+sid+") ");
	
//	
//	@Override
//	public void updateStudent(Student student) {
//	// TODO Auto-generated method stub
//	
//	}
	
	
	
	
	
	}
