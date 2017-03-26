package com.coderovers.makesurvey.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author Manish Karki
 * 
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RoleNotAssignedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private String reason = "Sorry, Something went wrong!!";
	
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
	

}
