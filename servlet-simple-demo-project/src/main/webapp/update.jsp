<%@page import="com.ibm.servlet_simple_demo_project.dto.Student"%>
<%@page import="com.ibm.servlet_simple_demo_project.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update page</title>
</head>
<body>
		<%
				int id = Integer.parseInt(request.getParameter("id"));
		       Student student = new StudentDao().getStudentByIdDao(id);
		       String gender = student.getGender();
		%>
		
	<div>
		<div>
			<h4>Welcome-To-Student-Update-Page</h4>
			<form action="studentUpdate" method="post">
				<label>Student-Id:</label><br> 
				<input type="number" name="studentId" value="<%=student.getId()%>"><br> <label>Student-Name:</label><br>
				<input type="text" name="studentName" value="<%=student.getName()%>"><br> <label>Student-Phone:</label><br>
				<input type="tel" name="studentPhone" value="<%=student.getPhone()%>"><br> <label>Student-Email:</label><br>
				<input type="email" name="studentEmail" value="<%=student.getEmail()%>"><br> <label>Student-Gender:</label><br>
				<input type="radio" name="gender" value="Male"  <%if(gender.equals("Male")){%>checked="checked"<%} %>>Male 
				<input type="radio" name="gender" value="Female" <%if(gender.equals("Female")){%>checked="checked"<%} %>>Female 
				<input type="radio" name="gender" value="Others" <%if(gender.equals("Other")){%>checked="checked"<%} %>>Others<br> 
				<input type="submit" value="update">
			</form>
		</div>
	</div>
</body>
</html>