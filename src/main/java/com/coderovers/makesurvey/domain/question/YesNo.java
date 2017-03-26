package com.coderovers.makesurvey.domain.question;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Transient;

import com.coderovers.makesurvey.domain.answer.YesNoAnswer;

/**
 * @author Krishna Bhat
 *
 */

@Entity
@DiscriminatorValue("YesNo")
public class YesNo extends Question {

	private static final long serialVersionUID = -3761303867879759190L;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private YesNoAnswer yesnoAnswer;

	@Transient
	String val = null;

	public String getDiscriminatorValue() {
		DiscriminatorValue val1 = this.getClass().getAnnotation(DiscriminatorValue.class);

		return val == null ? null : val1.value();
	}

	public YesNo() {
	}

	public YesNoAnswer getYesnoAnswer() {
		return yesnoAnswer;
	}

	public void setYesnoAnswer(YesNoAnswer yesnoAnswer) {
		this.yesnoAnswer = yesnoAnswer;
	}

}
