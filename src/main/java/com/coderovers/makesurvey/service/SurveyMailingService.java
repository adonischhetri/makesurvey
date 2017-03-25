package com.coderovers.makesurvey.service;

import com.coderovers.makesurvey.domain.User;

/**
 * @author Manish Karki
 * 
 */

public interface SurveyMailingService {

	/**
     * compose and send the message * */
	
	public void sendPreConfiguredMail(User surveyCreator);
	
	/** send a pre-configured message* */
    public void sendMail(String message);

}
