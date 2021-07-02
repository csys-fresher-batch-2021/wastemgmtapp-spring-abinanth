package com.abinanth.advice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.abinanth.dto.Message;
import com.abinanth.exception.ValidationException;

@ControllerAdvice
public class ErrorHandler {
	@Autowired
	Message message;

	@ExceptionHandler(ValidationException.class)
	public ResponseEntity<Message> registerServiceError(ValidationException e) {
		message.setErrorMessage(e.getMessage());
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}
}
