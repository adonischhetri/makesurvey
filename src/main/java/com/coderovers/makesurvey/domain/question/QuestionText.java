package com.coderovers.makesurvey.domain.question;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.coderovers.makesurvey.domain.answer.AnswerText;

/**
* @author Krishna Bhat
*
*/

@Entity
@DiscriminatorValue("Text_Question")
public class QuestionText extends Question {

	private static final long serialVersionUID = 4809542486713729710L;
		
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AnswerText answerText;
	
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

	    return val == null ? null : val.value();
	}
	
	public QuestionText(){}

	public AnswerText getAnswerText() {
		return answerText;
	}

	public void setAnswerText(AnswerText answerText) {
		this.answerText = answerText;
	}
	
}
