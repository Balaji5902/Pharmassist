package com.example.pharmassist.exception;

@SuppressWarnings("serial")
public class AdminNotFoundByIdException extends RuntimeException
{
	private String message;

	public AdminNotFoundByIdException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}


}
