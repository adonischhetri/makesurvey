package com.coderovers.makesurvey.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.domain.question.Question;
import com.coderovers.makesurvey.service.SurveyService;
import com.coderovers.makesurvey.util.ServiceHelper;

/**
 * @author Krishna Bhat
 *
 */

@Controller
@RequestMapping("/survey")
@SessionAttributes("questionList")
public class SurveyController {

	@Autowired
	SurveyService surveyService;

	@Autowired
	ServiceHelper serviceHelper;

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/addQuestion", method = RequestMethod.GET)
	public @ResponseBody Question addQuestion(@RequestParam("questionType") String questionType,
			@RequestParam("question") String question, Model model) {

		Question myQuestion = serviceHelper.createQuestion(questionType, question);

		// save to session....
		List<Question> questionList;
		if (!model.containsAttribute("questionList")) {
			questionList = new ArrayList<Question>();
			questionList.add(myQuestion);
			model.addAttribute("questionList", questionList);
		} else {
			questionList = (List<Question>) model.asMap().get("questionList");
			questionList.add(myQuestion);
		}

		return myQuestion;
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createSurvey(@ModelAttribute("survey") Survey survey, Model model) {
		List<Question> questionList = null;
		if (model.containsAttribute("questionList")) {
			questionList = (List<Question>) model.asMap().get("questionList");
		}
		model.addAttribute("questionList", questionList);
		return "survey";
	}

	@SuppressWarnings("unchecked")
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveUpdateSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result,
			RedirectAttributes redirectAttributes, Model model, SessionStatus status) {
		//System.out.println(survey);
		if (result.hasErrors()) {
			return "survey";
		}

		List<Question> questionList = null;
		if (model.containsAttribute("questionList")) {
			questionList = (List<Question>) model.asMap().get("questionList");
		}
		
		surveyService.saveOrUpdate(survey, questionList);
		status.setComplete();

		if (survey.getId() != 0) {
			redirectAttributes.addFlashAttribute("message", "Survey updated successfully!");
		} else {
			redirectAttributes.addFlashAttribute("message", "New survey added successfully!");
		}

		return "redirect:/survey";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listAllSurvey(Model model) {
		model.addAttribute("surveyList", surveyService.getAll());
		return "surveyList";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable("id") Long id, Model model) {
		model.addAttribute("survey", surveyService.getById(id));
		return "survey";
	}

	@RequestMapping("/delete/{id}")
	public String removeSurvey(@PathVariable("id") Long id) {
		surveyService.deleteSurvey(surveyService.getById(id));
		return "redirect:/survey";
	}
}
