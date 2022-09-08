package com.ty.carapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.carapp.dto.Car;

public interface CarRepository extends JpaRepository<Car, Integer>{

}
