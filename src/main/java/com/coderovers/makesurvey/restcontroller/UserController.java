package com.coderovers.makesurvey.restcontroller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.service.UserService;

/**
 * @author Manish Karki
 * 
 */
@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@RequestMapping(value={"/users"}, method = RequestMethod.POST)
	public ResponseEntity<User> createUser(@Valid @RequestBody User user){
		userService.save(user);
		return new ResponseEntity<User>( HttpStatus.OK);
	}

}
