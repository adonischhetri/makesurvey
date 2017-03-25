package com.coderovers.makesurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.service.SurveyMailingService;

/**
 * @author Manish Karki
 * 
 */
@Service	
public class SurveyMailingServiceImpl implements SurveyMailingService {
	@Autowired
	private MailSender mailSender;
    private SimpleMailMessage templateMessage;

    public void setTemplateMessage(SimpleMailMessage templateMessage) {
        this.templateMessage = templateMessage;
    }
    

	@Override
	public void sendPreConfiguredMail(User surveyCreator) {
		SimpleMailMessage msg = new SimpleMailMessage(this.templateMessage);
        msg.setTo(surveyCreator.getEmail());
        msg.setText(
            "Dear " + surveyCreator.getFirstName()
                + surveyCreator.getLastName()
                + ", thank you for placing order. Your order number is "
                + surveyCreator.getId());
        try{
            this.mailSender.send(msg);
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }

	}

	@Override
	public void sendMail(String message) {
		// TODO Auto-generated method stub

	}

}
