package com.ty.carapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.carapp.dto.ResponseStructure;

@ControllerAdvice
public class CarAppExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoIdFoundException.class)
	public ResponseEntity<ResponseStructure<String>> handler(NoIdFoundException exception) {

		ResponseStructure<String> responseStructure = new ResponseStructure<>();

		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage(" Not Found");
		responseStructure.setData(exception.getMessage());

		return new ResponseEntity<>(responseStructure, HttpStatus.NOT_FOUND);
	}

}
