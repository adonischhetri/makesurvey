package com.coderovers.makesurvey.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.coderovers.makesurvey.domain.answer.Response;

/**
 * @author Manish Karki
 * 
 */
@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {
	
	public Response getResponseById(Long id);

}
