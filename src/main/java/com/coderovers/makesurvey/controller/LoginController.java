package com.coderovers.makesurvey.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.service.UserService;

@Controller
public class LoginController {
	@Autowired
	UserService userSevice;

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String surveyCreator(Model model) {
		List<User> users = userSevice.findSurveyTakers();
		for(User usr : users){
			System.out.println("U= "+usr.getEmail());
		}
		model.addAttribute("surveyTakers", users);
		return "dashboard";
	}
	
	@RequestMapping(value = "/surveytaker", method = RequestMethod.GET)
	public String surveyTaker() {
		return "surveytaker";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";
	}

	@RequestMapping(value = "/loginfailed", method = RequestMethod.GET)
	public String loginerror(Model model) {

		model.addAttribute("error", "true");
		return "login";

	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(Model model, SessionStatus session) {
		session.setComplete();
		return "redirect:/welcome";
	}
}
