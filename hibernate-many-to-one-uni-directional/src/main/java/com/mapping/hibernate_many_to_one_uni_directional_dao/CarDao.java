package com.mapping.hibernate_many_to_one_uni_directional_dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.mapping.hibernate_many_to_one_uni_directional_dto.Car;

public class CarDao {

	EntityManagerFactory eMF = Persistence.createEntityManagerFactory("jpa");
	EntityManager em=eMF.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	public List<Car> saveCarDao(List<Car> cars){
		et.begin();
		for(Car car: cars) {
			em.persist(car);
		}
		return cars;
	}
}
