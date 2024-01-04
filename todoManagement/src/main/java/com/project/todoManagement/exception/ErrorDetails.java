package com.project.todoManagement.exception;

import java.time.LocalDateTime;

public class ErrorDetails {
	
	private LocalDateTime dateTime;
	private String message;
	private String path;
	private String errorCode;
	
	
	public ErrorDetails(LocalDateTime dateTime, String message, String path, String errorCode) {
		super();
		this.dateTime = dateTime;
		this.message = message;
		this.path = path;
		this.errorCode = errorCode;
	}

	

	
	public ErrorDetails() {
		super();
	}




	public LocalDateTime getDateTime() {
		return dateTime;
	}


	public void setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public String getErrorCode() {
		return errorCode;
	}


	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
	
	
	

}
