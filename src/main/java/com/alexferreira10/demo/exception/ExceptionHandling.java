package com.alexferreira10.demo.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.persistence.EntityNotFoundException;

// When happen an exception, it get and show the handling
@RestControllerAdvice
public class ExceptionHandling {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<?> Handling404() {
		return ResponseEntity.notFound().build();
	}

	// The invalid validation
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> Handling400(MethodArgumentNotValidException e) {
		var error = e.getFieldErrors();

		return ResponseEntity.badRequest().body(error.stream().map(DataError::new).toList());
	}

	public record DataError(String msg, String field) {

		public DataError(FieldError error) {
			this(error.getField(), error.getDefaultMessage());
		}
	}
}