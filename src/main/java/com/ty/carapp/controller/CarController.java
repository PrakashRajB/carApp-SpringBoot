package com.ty.carapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.carapp.dto.Car;
import com.ty.carapp.dto.ResponseStructure;
import com.ty.carapp.service.CarService;

@RestController
@RequestMapping("/cars")
public class CarController {

	@Autowired
	private CarService carService;

	@PostMapping
	public ResponseEntity<ResponseStructure<Car>> saveCar(@RequestBody Car car) {
		return carService.saveCar(car);
	}

	@GetMapping("/{id}")
	public ResponseEntity<ResponseStructure<Car>> getCarById(@PathVariable int id) {
		return carService.getCarById(id);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<ResponseStructure<String>> deleteCarById(@PathVariable int id) {
		return carService.deleteCarById(id);
	}

}
