package com.coderovers.makesurvey.domain.dto;

/**
 * @author Manish Karki
 * 
 */
public class DomainError {
	 
    private String message;
 
    public DomainError() {}
	    public DomainError(String message) {
	    	this.message = message;
 	    }
	    
	    public void setMessage(String message) {
 	        this.message = message;
	    }
	 
	    public String getMessage( ) {
 	        return message;
	    }
  	}
	
 
