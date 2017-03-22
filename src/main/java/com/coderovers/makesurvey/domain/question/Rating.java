package com.coderovers.makesurvey.domain.question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
* @author Krishna Bhat
*
*/

@Entity
@DiscriminatorValue("Rating")
public class Rating extends SingleChoice {

	private static final long serialVersionUID = -4574677237788841342L;

}
