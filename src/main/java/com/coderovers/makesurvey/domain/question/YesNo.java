package com.coderovers.makesurvey.domain.question;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

/**
 * @author Krishna Bhat
 *
 */

@Entity
@DiscriminatorValue("YesNo")
public class YesNo extends SingleChoice {

	private static final long serialVersionUID = -3761303867879759190L;

}
