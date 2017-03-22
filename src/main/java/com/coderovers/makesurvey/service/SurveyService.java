package com.coderovers.makesurvey.service;

import java.util.List;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.domain.User;

/**
 * @author Krishna Bhat
 *
 */

public interface SurveyService {
	public void saveOrUpdate(Survey survey);

	public void deleteSurvey(Survey survey);

	public Survey getById(Long id);

	public List<Survey> getAll();

	public List<Survey> getSurveyByCreator(User user);

	public List<Survey> searchSurvey(String keyword);
}
