package com.coderovers.makesurvey.exception;

/**
 * @author Krishna Bhat
 *
 */

public class InvalidSurveyException extends RuntimeException {

	private static final long serialVersionUID = -8386301353860937669L;

	private Long surveyId;

	public InvalidSurveyException(Long surveyId) {
		this.surveyId = surveyId;
	}

	public Long getSurveyId() {
		return surveyId;
	}

}
