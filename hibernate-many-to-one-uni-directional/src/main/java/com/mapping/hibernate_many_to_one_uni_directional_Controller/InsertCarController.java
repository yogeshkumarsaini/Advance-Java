package com.mapping.hibernate_many_to_one_uni_directional_Controller;

import java.util.Arrays;
import java.util.List;

import com.mapping.hibernate_many_to_one_uni_directional_dto.Car;

public class InsertCarController {
	public static void main(String[] args) {
		
		List<Car> cars =Arrays.asList(new Car(15, "Audi","Blue","Petrol",320000),new Car(65, "NEXON","Green","Electric",1000000));
				
		CarDao carDao=new CarDao();
		carDao.saveMultiple
	}
}
