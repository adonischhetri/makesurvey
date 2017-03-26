package com.coderovers.makesurvey.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

@Controller
public class LoginController {

	@RequestMapping(value = "/dashboard", method = RequestMethod.GET)
	public String surveyCreator() {
		return "dashboard";
	}
	
	@RequestMapping(value = "/surveytaker", method = RequestMethod.GET)
	public String surveyTaker() {
		return "surveytaker";
	}
	
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "dashboard";
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
