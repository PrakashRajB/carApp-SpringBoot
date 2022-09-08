package com.ty.carapp.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Car {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private double cost;
	private String brand;
	private String type;
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", cost=" + cost + ", brand=" + brand + ", type=" + type + "]";
	}

	
}
