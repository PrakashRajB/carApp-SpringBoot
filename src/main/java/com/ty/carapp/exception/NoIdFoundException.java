package com.ty.carapp.exception;

public class NoIdFoundException extends RuntimeException{
	
	private String message="Given Id Not Found";
	
	public NoIdFoundException() {
		
	}

	public NoIdFoundException(String message) {
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}
	
}
