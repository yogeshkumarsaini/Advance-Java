<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration Form</title>
</head>
<body>
	<h4>Welcome-To-Student_registration-Page</h4>
	<br>
	<form action="studentRegister" method="get">
		<label>Student-ID</label><br>
		<br> <input type="text" placeholder="enter-student-id"
			name="studentId"><br>
		<br> <label>Student-Name</label><br>
		<br> <input type="text" placeholder="enter-student-name"
			name="studentName"><br>
		<br> <label>Student-Phone</label><br>
		<br> <input type="tel" placeholder="enter-student-phone"
			name="studentPhone"><br>
		<br> <label>Student-Email</label><br>
		<br> <input type="email" placeholder="enter-student-email"
			name="studentEmail"><br>
		<br> <label>Student-Gender</label><br>
		<br> <input type="radio" name="gender" value="Male">Male 
			<input  type="radio" name="gender" value ="Female">Female 
			<input type="radio"  name="gender" value="Other">Other<br>
		<br><input type="submit" value="register">
	</form>
</body>
</html>