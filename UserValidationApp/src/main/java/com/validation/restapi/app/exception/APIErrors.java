package com.validation.restapi.app.exception;

import java.util.Date;

import org.springframework.http.HttpStatus;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class APIErrors {

	
	private int statuscode;
	private String message;
	private Date date;
	private String path;
	private HttpStatus httpMessage;
}
