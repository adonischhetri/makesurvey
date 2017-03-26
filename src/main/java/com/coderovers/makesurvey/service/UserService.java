package com.coderovers.makesurvey.service;

import java.util.List;

import com.coderovers.makesurvey.domain.Roles;
import com.coderovers.makesurvey.domain.User;

/**
 * @author Manish Karki
 * 
 */

public interface UserService {
	
	public void save(User user);
	public User register(User user, String role);
	public User getUserById(Long id);
	
	List<User> findSurveyTakers();

}
