package com.ty.carapp.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.carapp.dto.Car;
import com.ty.carapp.repository.CarRepository;

@Repository
public class CarDao {

	@Autowired
	private CarRepository carRepository;

	public Car saveCar(Car car) {
		System.out.println(car);
		return carRepository.save(car);
	}

	public Car getCarById(int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isPresent()) {
			return optional.get();
		} else {
			return null;
		}
	}

	public boolean deleteCarById(int id) {
		Optional<Car> optional = carRepository.findById(id);
		if (optional.isPresent()) {
			carRepository.delete(optional.get());
			return true;
		} else {
			return false;
		}
	}

}
