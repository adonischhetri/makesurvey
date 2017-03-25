package com.coderovers.makesurvey.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.service.SecurityService;
import com.coderovers.makesurvey.service.UserService;


/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	@Autowired
	private UserService userService;
	@Autowired
	private SecurityService securityService;

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = {"/", "/welcome"}, method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);

		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

		String formattedDate = dateFormat.format(date);

		model.addAttribute("serverTime", formattedDate);

		return "welcome";// tiles
	}

	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(@ModelAttribute("newUser") User user) {
		return "signup";
	}

	@RequestMapping(value = "/signup", method = RequestMethod.POST)
	public String register(@Valid @ModelAttribute("newUser") User surveyCreator, BindingResult result,
			RedirectAttributes redirectAttributes) {
		if (result.hasErrors()){
			System.out.println("No error");
			return "signup";
		}
		userService.register(surveyCreator);
		redirectAttributes.addFlashAttribute("surveyCreator", surveyCreator);
		return "redirect:/success";
	}

	@RequestMapping(value = {"/success","/login"}, method = RequestMethod.GET)
	public String success() {
		System.out.println("inside success");
		return "login";
	}
	
	

}
