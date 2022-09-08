package com.ty.carapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.carapp.dao.CarDao;
import com.ty.carapp.dto.Car;
import com.ty.carapp.dto.ResponseStructure;
import com.ty.carapp.exception.NoIdFoundException;

@Service
public class CarService {

	@Autowired
	private CarDao carDao;

	public ResponseEntity<ResponseStructure<Car>> saveCar(Car car) {

		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(carDao.saveCar(car));

		return new ResponseEntity<>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Car>> getCarById(int id) {

		Car car = carDao.getCarById(id);
		ResponseStructure<Car> responseStructure = new ResponseStructure<>();
		if (car != null) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(car);

			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			throw new NoIdFoundException("Id : "+id+" Not Found");
		}
	}

	public ResponseEntity<ResponseStructure<String>> deleteCarById(int id) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		if (carDao.deleteCarById(id)) {
			responseStructure.setStatus(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData("Car with ID" + id + " Deleted Successfully");

			return new ResponseEntity<>(responseStructure, HttpStatus.OK);
		} else {
			responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
			responseStructure.setMessage("NOT FOUND");
			responseStructure.setData("Car with ID" + id + " is not found");
			return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
		}
	}

}
