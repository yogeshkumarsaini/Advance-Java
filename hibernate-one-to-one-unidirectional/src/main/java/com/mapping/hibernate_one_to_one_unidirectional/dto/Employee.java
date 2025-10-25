package com.mapping.hibernate_one_to_one_unidirectional.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employee {

	@Id
	private int id;
	private String name;
	private String email;
	private long phone;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="LaptopId")
	private Laptop laptop;
	
	public Employee(int id, String name, String email, long phone) {
		this.id=id;
		this.name=name;
		this.email=email;
		this.phone=phone;
	}
}
