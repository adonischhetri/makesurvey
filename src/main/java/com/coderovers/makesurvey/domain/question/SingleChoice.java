package com.coderovers.makesurvey.domain.question;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToOne;

/**
 * @author Krishna Bhat
 *
 */

@Entity
//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Inheritance(strategy = InheritanceType.JOINED)
public class SingleChoice extends Choice {

	private static final long serialVersionUID = -8529640765775680330L;

	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Option option;

	SingleChoice() {
	}

	public Option getOption() {
		return option;
	}

	public void setOption(Option option) {
		this.option = option;
	}

}
