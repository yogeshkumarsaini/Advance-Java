package com.jspider.jdbc_prepared_crud_architecture.dto;

/**
 * 
 * @author yogesh
 * 
 *         This is our Student encapsulation Class which has id, name, email,
 *         phone
 *
 */

public class Student {
	private int id;
	private String name;
	private String email;
	private long phone;

	public Student() {
		super();
	}

	public Student(int id, String name, String email, long phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "id: " + id + "\nname: " + name + "\nemail: " + email + "\nphone: " + phone;
	}

}
