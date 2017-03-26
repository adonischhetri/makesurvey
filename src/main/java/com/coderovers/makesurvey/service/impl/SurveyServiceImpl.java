package com.coderovers.makesurvey.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.domain.answer.Response;
import com.coderovers.makesurvey.domain.question.Question;
import com.coderovers.makesurvey.exception.InvalidSurveyException;
import com.coderovers.makesurvey.repository.SurveyRepository;
import com.coderovers.makesurvey.repository.UserRepository;
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

	@Autowired
	private UserRepository userRepository;

	@Override
	public void saveOrUpdate(Survey survey, List<Question> questions) {

		String username = SecurityContextHolder.getContext().getAuthentication().getName();

		survey.setSurveyCreator(userRepository.findByUserName(username));
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

	@Override
	@PreAuthorize("hasRole('ROLE_TAKER')")
	public Survey validate(Long surveyId) {
		Survey survey = surveyRepository.findOne(surveyId);
		for(Question question : survey.getQuestions()){
			Response response = new Response();
			response.setAnswer("");
			question.setResponses(response);
		}
		//System.out.println("SURVEY= "+survey.getQuestions().size());
		if (survey == null || survey.getQuestions().size() == 0) {
			throw new InvalidSurveyException(surveyId);
		}
		return survey;
	}
	
	public void saveSurvey(Survey survey){
		surveyRepository.save(survey);
	}

}
