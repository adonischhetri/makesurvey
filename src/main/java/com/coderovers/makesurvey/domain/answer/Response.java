package com.coderovers.makesurvey.domain.answer;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.domain.question.Question;

/**
 * @author Krishna Bhat
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // Least normalisation
														// strategy
@DiscriminatorColumn(name = "Answer_Type", discriminatorType = DiscriminatorType.STRING)
public class Response {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@OneToOne
	private User surveyTaker;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "question_id")
	private Question question;

	public String answer;

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

}
