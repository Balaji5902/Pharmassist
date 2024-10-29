package com.example.pharmassist.exception;

public class NoUsersFoundException extends RuntimeException
{
	private final String message;

	public NoUsersFoundException(String message) 
	{
		super();
		this.message = message;
	}

	public String getMessage() 
	{
		return message;
	}




}
