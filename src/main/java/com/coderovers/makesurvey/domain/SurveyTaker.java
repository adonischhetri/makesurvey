package com.coderovers.makesurvey.domain;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

import com.coderovers.makesurvey.domain.answer.Response;

/**
 * @author Manish Karki
 * 
 */
@Entity
@DiscriminatorValue("Survey_Taker")
public class SurveyTaker extends User {

	private static final long serialVersionUID = 1L;

	@OneToOne(cascade = CascadeType.ALL)
	private Response response;

}
