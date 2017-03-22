package com.coderovers.makesurvey.domain.question;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

/**
* @author Krishna Bhat
*
*/

@Entity
//@DiscriminatorValue("Choice")
@Inheritance(strategy = InheritanceType.JOINED)
public class Choice extends Question {

	private static final long serialVersionUID = 5466423746357378325L;
	
	
}
