package com.coderovers.makesurvey.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Component;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.service.SurveyService;

/**
* @author Krishna Bhat
*
*/

@Component
public class SurveyControllerHelper {
	@Autowired
	private SurveyService surveyService;
	
	public Survey validateSurvey(Long surveyId){
		return surveyService.validate(surveyId);
	}
	
	public void saveSurvey(Survey survey) {
		surveyService.saveSurvey(survey);
	}
}
