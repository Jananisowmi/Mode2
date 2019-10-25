<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<h1>Exam List</h1>

<table border="1">
<tr>
<th>ExamID</th>
<th>Subject Name</th>
<th>Marks</th>
<th>Action</th>
</tr>
<c:set var="sid" value="${sid}"/>
<c:forEach var="exam" items="${examList}">
<c:set var="sid" value="${exam.sid}"/>
<tr>
<td>${exam.mi}</td>
<td>${exam.subName}</td>
<td>${exam.marks}</td>
<td><a href="editExam?mi=${exam.mi}&sName=<%=request.getParameter("sName") %>">Edit</a>&nbsp;&nbsp;&nbsp;&nbsp;
<a href="deleteExam?mi=${exam.mi}">Delete</a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>

</tr>
</c:forEach>
<tr colspan="2">
<td>
<a href="newExam?sid=<%=request.getParameter("sid")%>&sName=<%=request.getParameter("sName") %>"> Add marks in the result form </a>&nbsp;&nbsp;&nbsp;&nbsp;</br>

<a href="/SpringMVCHibernateCRUD/">Go To Home Page</a>&nbsp;&nbsp;&nbsp;&nbsp;
</td>
</tr>
</table>

</div>
</body>
</html>
