package com.coderovers.makesurvey.domain.answer;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

import com.coderovers.makesurvey.domain.SurveyTaker;

/**
 * @author Krishna Bhat
 *
 */

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE) //Least normalisation strategy
@DiscriminatorColumn(
  name="Answer_Type", 
  discriminatorType=DiscriminatorType.STRING
  )
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@OneToOne
	private SurveyTaker surveyTaker;

}
