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
@DiscriminatorValue("YesNo")
public class YesNo extends Question {

	private static final long serialVersionUID = -3761303867879759190L;
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private AnswerText answerText;
	
	@Transient
	public String getDiscriminatorValue(){
	    DiscriminatorValue val = this.getClass().getAnnotation( DiscriminatorValue.class );

	    return val == null ? null : val.value();
	}
	
	public YesNo(){}

	public AnswerText getAnswerText() {
		return answerText;
	}

	public void setAnswerText(AnswerText answerText) {
		this.answerText = answerText;
	}
	
}
