<%@page import="com.ibm.servlet_simple_demo_project.dto.Student"%>
<%@page import="java.util.List"%>
<%@page import="com.ibm.servlet_simple_demo_project.dao.StudentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Display page</title>
</head>
<body>
	<%
	StudentDao dao = new StudentDao();
	List<Student> students = dao.getAllDetailsDao();
	%>

	<table border="2">

		<tr>
			<th>id</th>
			<th>name</th>
			<th>email</th>
			<th>phone</th>
			<th>gender</th>
			<th colspan="2">action</th>

		</tr>
		<%
		for (Student student : students) {
		%>
		<tr>
			<td><%=student.getId()%></td>
			<td><%=student.getName()%></td>
			<td><%=student.getEmail()%></td>
			<td><%=student.getPhone()%></td>
			<td><%=student.getGender()%></td>
			<td><a href="delete?id=<%=student.getId()%>">Delete</a></td>
			<td><a href="update.jsp?id=<%=student.getId()%>">Update</a></td>
		</tr>
		<%
		}
		%>


	</table>
</body>
</html>