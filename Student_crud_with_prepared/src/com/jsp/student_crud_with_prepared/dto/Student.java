package com.jsp.student_crud_with_prepared.dto;
/**
 * 
 * @author yogesh
 *
 */
public class Student {

	private int studentId;
	private String studentName;
	private String studentEmail;
	private long studentPhone;
	
	/*
	 * No argument constructor
	 */
	public Student() {
		super();
	}

	/*
	 * Argument constructor
	 */
	public Student(int studentId, String studentName, String studentEmail, long studentPhone) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.studentEmail = studentEmail;
		this.studentPhone = studentPhone;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	public String getStudentEmail() {
		return studentEmail;
	}

	public void setStudentEmail(String studentEmail) {
		this.studentEmail = studentEmail;
	}

	public long getStudentPhone() {
		return studentPhone;
	}

	public void setStudentPhone(long studentPhone) {
		this.studentPhone = studentPhone;
	}

	@Override
	public String toString() {
		return "student [studentId=" + studentId + ", studentName=" + studentName + ", studentEmail=" + studentEmail
				+ ", studentPhone=" + studentPhone + ", getStudentId()=" + getStudentId() + ", getStudentName()="
				+ getStudentName() + ", getStudentEmail()=" + getStudentEmail() + ", getStudentPhone()="
				+ getStudentPhone() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	

}
