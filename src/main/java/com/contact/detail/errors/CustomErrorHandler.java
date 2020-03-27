/**
 * 
 */
package com.contact.detail.errors;

import org.hibernate.exception.ConstraintViolationException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.contact.detail.controller.ResponseData;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;

/**
 *
 *
 */
@RestControllerAdvice(basePackages = "com.contact.detail")
public class CustomErrorHandler {
	private static Logger logger = LoggerFactory.getLogger(CustomErrorHandler.class);

	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<ResponseData<String>> handleConstraintViolationException(Exception error) throws Exception {
		ResponseData<String> response = new ResponseData<>();
		response.setResponseMessage(error.getMessage());
		logger.error(error.getMessage(), error);
		error.printStackTrace();
		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ResponseData<String>> handleInvalidFormatException(Exception error) throws Exception {
		ResponseData<String> response = new ResponseData<>();
		response.setResponseMessage("Invalid JSON input");
		logger.error(error.getMessage(), error);
		error.printStackTrace();
		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(JsonMappingException.class)
	public ResponseEntity<ResponseData<String>> handleJsonMappingException(Exception error) throws Exception {
		ResponseData<String> response = new ResponseData<>();
		response.setResponseMessage(error.getMessage());
		logger.error(error.getMessage(), error);
		error.printStackTrace();
		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<ResponseData<String>> handleMessageNotReadableException(Exception error) throws Exception {
		ResponseData<String> response = new ResponseData<>();
		response.setResponseMessage("Invalid JSON input");
		logger.error(error.getMessage(), error);
		error.printStackTrace();
		return ResponseEntity.badRequest().body(response);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ResponseData<String>> handleDefaultExceptions(Exception error) {
		ResponseData<String> response = new ResponseData<>();
		response.setResponseMessage("Error processing request.");
		logger.error(error.getMessage(), error);
		error.printStackTrace();
		return ResponseEntity.badRequest().body(response);
	}
}
