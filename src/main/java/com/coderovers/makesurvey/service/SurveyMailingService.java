package com.coderovers.makesurvey.service;

import com.coderovers.makesurvey.domain.SurveyCreator;

/**
 * @author Manish Karki
 * 
 */

public interface SurveyMailingService {

	/**
     * compose and send the message * */
	
	public void sendPreConfiguredMail(SurveyCreator surveyCreator);
	
	/** send a pre-configured message* */
    public void sendMail(String message);

}
