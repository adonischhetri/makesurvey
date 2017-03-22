package com.coderovers.makesurvey.service;

import com.coderovers.makesurvey.domain.answer.Response;

/**
 * @author Manish Karki
 * 
 */

public interface ResponseService {
	
	public void saveResponse(Response response);
	
	public Response getResponseById(Long id);
	
	public void deleteResponse(Response response);

}
