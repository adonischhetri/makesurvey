package com.coderovers.makesurvey.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.coderovers.makesurvey.domain.dto.DomainError;
import com.coderovers.makesurvey.domain.dto.DomainErrors;
import com.coderovers.makesurvey.exception.RoleNotAssignedException;


/**
 * @author Manish Karki
 * 
 */
@ControllerAdvice
public class ExceptionController {

	@Autowired
	MessageSourceAccessor messageAccessor;
	public static final String DEFAULT_ERROR_VIEW = "general-error";

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ResponseBody
	public DomainErrors handleException(
			MethodArgumentNotValidException exception) {
		List<FieldError> fieldErrors = exception.getBindingResult()
				.getFieldErrors();

		DomainErrors errors = new DomainErrors();
		errors.setErrorType("ValidationError");
		for (FieldError fieldError : fieldErrors) {
			DomainError error = new DomainError(
					messageAccessor.getMessage(fieldError));
			errors.addError(error);
		}

		return errors;
	}
	
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@org.springframework.web.bind.annotation.ExceptionHandler(RoleNotAssignedException.class)
	public ModelAndView handleError(HttpServletRequest req, RoleNotAssignedException exception) {
		 ModelAndView mav = new ModelAndView();
		 mav.addObject("reason", exception.getReason());
		 System.out.println("helllo"+exception.getReason());
		 mav.setViewName(DEFAULT_ERROR_VIEW);
		 return mav;
	}
	

}