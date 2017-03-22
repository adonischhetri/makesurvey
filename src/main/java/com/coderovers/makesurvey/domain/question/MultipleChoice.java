package com.coderovers.makesurvey.domain.question;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 * @author Krishna Bhat
 *
 */

@Entity
@DiscriminatorValue("Multiple_Choice")
public class MultipleChoice extends Choice {

	private static final long serialVersionUID = 4635214526972041047L;

	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Option> options;

	MultipleChoice() {
	}

	public List<Option> getOptions() {
		return options;
	}

	public void setOptions(List<Option> options) {
		this.options = options;
	}

}
