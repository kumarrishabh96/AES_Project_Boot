package com.ty.aes_project_boot.exception;

public class NoSuchIdFoundException extends RuntimeException {

	private String message = "No such ID found";

	public NoSuchIdFoundException(String message) {

		this.message = message;
	}

	public NoSuchIdFoundException() {
	}

	@Override
	public String getMessage() {
		return message;
	}

}