package com.coderovers.makesurvey.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;

import com.coderovers.makesurvey.domain.question.Question;

/**
 * @author Manish Karki cmd + shift + o
 */
@Entity
public class Survey implements Serializable {

	private static final long serialVersionUID = -4937866292277419840L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotEmpty
	@Size(min=5, max=50, message="Survey title must be between 5 and 50")
	private String title;
	@NotEmpty
	private String description;

	@Temporal(TemporalType.TIMESTAMP)
	private Date added_date;
	
	private boolean visibility = true;

	@ManyToOne()
	private User surveyCreator;

	//@OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE, CascadeType.REFRESH, CascadeType.DETACH})
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "Survey_Question", joinColumns =
    	@JoinColumn(name = "FK_Survey_id", referencedColumnName= "id"),
            inverseJoinColumns = @JoinColumn(name = "FK_Question_id", referencedColumnName = "id")
    )
	private List<Question> questions;

	Survey() {
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getAdded_date() {
		return added_date;
	}

	public void setAdded_date(Date added_date) {
		this.added_date = added_date;
	}

	public boolean isVisibility() {
		return visibility;
	}

	public void setVisibility(boolean visibility) {
		this.visibility = visibility;
	}
	

	public User getSurveyCreator() {
		return surveyCreator;
	}

	public void setSurveyCreator(User surveyCreator) {
		this.surveyCreator = surveyCreator;
	}

	public List<Question> getQuestions() {
		return questions;
	}

	public void setQuestions(List<Question> questions) {
		this.questions = questions;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((added_date == null) ? 0 : added_date.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		result = prime * result + (visibility ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Survey other = (Survey) obj;
		if (added_date == null) {
			if (other.added_date != null)
				return false;
		} else if (!added_date.equals(other.added_date))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		if (visibility != other.visibility)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Survey [id=" + id + ", title=" + title + ", description=" + description + ", added_date=" + added_date
				+ ", visibility=" + visibility + ", surveyCreator=" + surveyCreator + ", questions=" + questions + "]";
	}
	
	

}
