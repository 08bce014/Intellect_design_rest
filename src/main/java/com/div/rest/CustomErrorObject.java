package com.div.rest;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;

public class CustomErrorObject implements Serializable{

	private static final long serialVersionUID = -6839345326601547899L;

	private HttpStatus status;

	private String exceptionCode;

	private String exceptionMessage;

	private List <FieldError> errors = null;

	public CustomErrorObject() {
	    // Default
	}
	public HttpStatus getStatus() {
		return status;
	}
	public void setStatus(HttpStatus status) {
		this.status = status;
	}
	public String getExceptionCode() {
		return exceptionCode;
	}
	public void setExceptionCode(String exceptionCode) {
		this.exceptionCode = exceptionCode;
	}
	public String getExceptionMessage() {
		return exceptionMessage;
	}
	public void setExceptionMessage(String exceptionMessage) {
		this.exceptionMessage = exceptionMessage;
	}
	public List<FieldError> getErrors() {
		return errors;
	}
	public void setErrors(List<FieldError> errors) {
		this.errors = errors;
	}
	
	
}
