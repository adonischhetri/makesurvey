package com.coderovers.makesurvey.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.enumtype.Role;
import com.coderovers.makesurvey.service.UserService;

/**
 * @author Manish Karki
 * 
 */

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute("newUser") User user) {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("newUser") User surveyCreator, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()) {
			System.out.println("No error");
			return "signup";
		}
		userService.register(surveyCreator, Role.CREATOR.getRole());
		redirectAttributes.addFlashAttribute("surveyCreator", surveyCreator);
		return "redirect:/success";
	}

	@RequestMapping(value = { "/success", "/login" }, method = RequestMethod.GET)
	public String success() {
		System.out.println("inside success");
		return "login";
	}
	
	@RequestMapping(value ="/surveyTakers", method = RequestMethod.POST)
	public @ResponseBody User surveyTaker(@Valid @RequestBody User user){
		userService.register(user,"TAKER");
		return user;
	}
	
}
