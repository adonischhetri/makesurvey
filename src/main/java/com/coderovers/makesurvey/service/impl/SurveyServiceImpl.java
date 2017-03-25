package com.coderovers.makesurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.domain.question.Question;
import com.coderovers.makesurvey.repository.SurveyRepository;
import com.coderovers.makesurvey.service.SurveyService;

/**
 * @author Krishna Bhat
 *
 */

@Service
@Transactional
public class SurveyServiceImpl implements SurveyService {

	@Autowired
	private SurveyRepository surveyRepository;

	@Override
	public void saveOrUpdate(Survey survey,  List<Question> questions) {
		survey.setQuestions(questions);
		surveyRepository.save(survey);
	}

	@Override
	public void deleteSurvey(Survey survey) {
		surveyRepository.delete(survey);
	}

	@Override
	public Survey getById(Long id) {
		return surveyRepository.findOne(id);
	}

	@Override
	public List<Survey> getAll() {
		return (List<Survey>) surveyRepository.findAll();
	}

	@Override
	public List<Survey> getSurveyByCreator(User user) {
		return surveyRepository.findSurveyBySurveyCreator(user);
	}

	@Override
	public List<Survey> searchSurvey(String keyword) {
		return surveyRepository.findByTitleContainsOrDescriptionContainsAllIgnoreCaseOrderByTitleAsc(keyword, keyword);
	}

}
