package com.mapping.hibernate_many_to_one_uni_directional_dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.ManyToAny;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Car {

	@Id
	private int id;
	private String name;
	private String color;
	private String type;
	private double price;
	
	@ManyToOne
	private Person person;
	
}
