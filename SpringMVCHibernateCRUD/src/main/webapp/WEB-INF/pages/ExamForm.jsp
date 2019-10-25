

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>New/Edit Exam</title>
</head>
<body>
    <div align="center">
        <h1>New/Edit Exam <%=request.getParameter("sName") %></h1>
        <form:form action="saveExam" method="post" modelAttribute="exam">
        <table bordr="1">
         <form:hidden path="mi"/>
         <form:hidden path="sid"/>
         
            <tr>
                <td>Subject Name:</td>
                <td>
               <form:select path="subName" >
               <form:option value="CoreJava">CoreJava</form:option>
               <form:option value="SQL">SQL</form:option>
               <form:option value="Spring">Spring</form:option>
               <form:option value="HTML">HTML</form:option>
               <form:option value="Hibernate">Hibernate</form:option>
               </form:select>
               </td>
            </tr>
            <tr>
                <td>Marks:</td>
                <td><form:input path="marks" /></td>
            </tr>
            <tr>
                <td>SID:</td>
                <td><form:input path="sid" readonly="readonly" class="required"/></td>
            </tr>
             
            <tr>
                <td colspan="2" align="center"><input type="submit" value="Save"></td>
            </tr>
        </table>
        </form:form>
        
        <h4> <a href="showExam?sid=${exam.sid}&sName=<%=request.getParameter("sName")%>"></a></h4>
    </div>
</body>
</html>