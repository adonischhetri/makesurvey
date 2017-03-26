package com.coderovers.makesurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.domain.User;

/**
 * @author Krishna Bhat
 *
 */

@Repository
public interface SurveyRepository extends CrudRepository<Survey, Long> {

	public List<Survey> findSurveyBySurveyCreator(User user);

	//@Query("SELECT s FROM Survey s WHERE s.title LIKE %:keyword% OR s.description LIKE %:keyword%")
	public List<Survey> findByTitleContainsOrDescriptionContainsAllIgnoreCaseOrderByTitleAsc(String keywordTitle, String keywordDescription);
	
}
