package com.validation.restapi.app.exception;

public class UserNotFoundExcetion extends RuntimeException {

	public UserNotFoundExcetion(String msg) {
		super(msg);
	}
}
