package com.coderovers.makesurvey.domain.answer;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Krishna Bhat
 *
 */
@Entity
@DiscriminatorValue("Answer_YesNo")
public class YesNoAnswer extends Response implements Serializable {
	private static final long serialVersionUID = -790859050831162425L;

	public boolean answer;
	
	public YesNoAnswer(){}

	public boolean getAnswer() {
		return answer;
	}

	public void setAnswer(boolean answer) {
		this.answer = answer;
	}

}
