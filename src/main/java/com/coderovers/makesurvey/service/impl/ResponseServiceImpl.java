package com.coderovers.makesurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderovers.makesurvey.domain.answer.Response;
import com.coderovers.makesurvey.repository.ResponseRepository;
import com.coderovers.makesurvey.service.ResponseService;

/**
 * @author Manish Karki
 * 
 */
@Service
@Transactional
public class ResponseServiceImpl implements ResponseService {
	
	@Autowired
	private ResponseRepository responseRepository;

	@Override
	public void saveResponse(Response response) {
		responseRepository.save(response);

	}

	@Override
	public Response getResponseById(Long id) {
		return responseRepository.getResponseById(id);
	}

	@Override
	public void deleteResponse(Response response) {
		responseRepository.delete(response);

	}

}
