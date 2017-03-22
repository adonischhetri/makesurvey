package com.coderovers.makesurvey.domain.answer;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

import com.coderovers.makesurvey.domain.question.Choice;

/**
 * @author Manish Karki
 * 
 */

@Entity
@DiscriminatorValue("choices")
public class ChoiceAnswer extends Response {
	@OneToMany(cascade = CascadeType.REMOVE)
	@JoinTable(name = "response_choice")
	private List<Choice> choice;

	public List<Choice> getChoice() {
		return choice;
	}

	public void setChoice(List<Choice> choice) {
		this.choice = choice;
	}

	
}
