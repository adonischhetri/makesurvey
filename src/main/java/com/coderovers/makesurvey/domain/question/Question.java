package com.coderovers.makesurvey.domain.question;

import java.io.Serializable;

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
import javax.persistence.OneToOne;

import com.coderovers.makesurvey.domain.answer.Response;
import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * @author Krishna Bhat
 *
 */

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "Question_Type", discriminatorType = DiscriminatorType.STRING)
public class Question implements Serializable {

	private static final long serialVersionUID = 4919794149950624062L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String title; // Question title

	@JsonIgnore
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Response responses;

	public Question() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Response getResponses() {
		return responses;
	}

	public void setResponses(Response responses) {
		this.responses = responses;
	}

	
	
}
