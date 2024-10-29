package com.example.pharmassist.exceptionhandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.pharmassist.exception.NoUsersFoundException;
import com.example.pharmassist.exception.UserNotFoundByIdException;
import com.example.pharmassist.util.AppResponseBuilder;
import com.example.pharmassist.util.ErrorStructure;

@RestControllerAdvice
public class UserExceptionHandler 
{
	private final AppResponseBuilder appResponseBuilder;

	public UserExceptionHandler(AppResponseBuilder appResponseBuilder) 
	{
		super();
		this.appResponseBuilder = appResponseBuilder;
	}

	@ExceptionHandler(UserNotFoundByIdException.class)
	public static <T> ResponseEntity<ErrorStructure<String>> handleUserNotFoundById(UserNotFoundByIdException ex) {
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"User not found by Id");

	}

	@ExceptionHandler(NoUsersFoundException.class)
	public static ResponseEntity<ErrorStructure<String>> handleNoUsersFound(NoUsersFoundException ex){
		return AppResponseBuilder.error(HttpStatus.NOT_FOUND, ex.getMessage(),"User not found under requested criteria");
	}

}
