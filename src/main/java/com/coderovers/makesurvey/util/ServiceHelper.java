package com.coderovers.makesurvey.util;

import org.springframework.stereotype.Component;

import com.coderovers.makesurvey.domain.question.Question;
import com.coderovers.makesurvey.domain.question.QuestionText;
import com.coderovers.makesurvey.domain.question.YesNo;

/**
 * @author Krishna Bhat
 *
 */

@Component
public class ServiceHelper {
	public Question createQuestion(String questionType, String question) {
		Question myQuestion;
		if (questionType.equals("0")) {
			myQuestion = new YesNo();
		} else {
			myQuestion = new QuestionText();
		}
		myQuestion.setTitle(question);
		return myQuestion;
	}
}
