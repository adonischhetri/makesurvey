package com.coderovers.makesurvey.service;

import java.util.List;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.domain.question.Question;

/**
 * @author Krishna Bhat
 *
 */

public interface SurveyService {
	public void saveOrUpdate(Survey survey,  List<Question> questions);

	public void deleteSurvey(Survey survey);

	public Survey getById(Long id);

	public List<Survey> getAll();

	public List<Survey> getSurveyByCreator(User user);

	public List<Survey> searchSurvey(String keyword);
	
	public Survey validate(Long surveyId);
	
	public void saveSurvey(Survey survey);
}
