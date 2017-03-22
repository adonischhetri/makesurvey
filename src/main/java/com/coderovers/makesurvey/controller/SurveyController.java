package com.coderovers.makesurvey.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderovers.makesurvey.domain.Survey;
import com.coderovers.makesurvey.service.SurveyService;

/**
 * @author Krishna Bhat
 *
 */

@Controller
@RequestMapping("/survey")
public class SurveyController {

	@Autowired
	SurveyService surveyService;

	@RequestMapping(value = "/create", method = RequestMethod.GET)
	public String createSurvey(@ModelAttribute("survey") Survey survey) {
		return "survey";
	}

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public String saveUpdateSurvey(@Valid @ModelAttribute("survey") Survey survey, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			return "survey";
		}

		if(survey.getId() != 0){
			redirectAttributes.addFlashAttribute("message", "Survey updated successfully!");
		}else{
			redirectAttributes.addFlashAttribute("message", "New survey added successfully!");
		}
		
		surveyService.saveOrUpdate(survey);
		
		return "redirect:/";
	}

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String listAllSurvey(Model model) {
		model.addAttribute("surveyList", surveyService.getAll());
		return "listall";
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editSurvey(@PathVariable("id") Long id, Model model) {
		model.addAttribute("survey", surveyService.getById(id));
		return "survey";
	}
	
	@RequestMapping("/remove/{id}")
    public String removeSurvey(@PathVariable("id") Long id){
		
		surveyService.deleteSurvey(surveyService.getById(id));
        return "redirect:/";
    }
}
