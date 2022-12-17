package com.ty.aes_project_boot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ty.aes_project_boot.util.ResponseStructure;

public class ApplicationExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NoSuchIdFoundException.class)
	public ResponseEntity<ResponseStructure<?>> noSuchIdFoundException(NoSuchIdFoundException exception) {
		ResponseStructure<String> responseStructure = new ResponseStructure<>();
		responseStructure.setStatus(HttpStatus.NOT_FOUND.value());
		responseStructure.setMessage("No such id found");
		responseStructure.setData(exception.getMessage());
		return new ResponseEntity<ResponseStructure<?>>(responseStructure, HttpStatus.NOT_FOUND);

	}
}
