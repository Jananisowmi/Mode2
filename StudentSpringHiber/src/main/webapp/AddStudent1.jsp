<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form"
prefix="springForm"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

 <springForm:form method="POST" commandName="Student" action="AddStudent1" >
 <center>
  Roll Number :
  <springForm:input path="rollNum"/>
   Student Name :
  <springForm:input path="sName"/>
   Age :
  <springForm:input path="age"/>
 Gender:
<SpringForm:radiobutton path="gender" value="Male">Male</SpringForm:radiobutton>
<SpringForm:radiobutton path="gender" value="Female">Female</SpringForm:radiobutton>
Country:
<SpringForm:select path="country"/>
<SpringForm:option value="" label="Select Country"></SpringForm:option>
<SpringForm:option value="India" label="India"></SpringForm:option>
<SpringForm:option value="America" label="America"></SpringForm:option>
<SpringForm:option value="Africa" label="Africa"></SpringForm:option>
Date Of Joining:
<SpringForm:input path="dateOfJoin"/>
Final Score:
<SpringForm:input path="finalScore"/>
<SpringForm:input path="submit" value="Submit"/>
 </center>
</springForm:form>
</body>
</html>