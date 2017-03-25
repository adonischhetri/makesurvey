package com.coderovers.makesurvey.service;

import com.coderovers.makesurvey.domain.User;

/**
 * @author Manish Karki
 * 
 */

public interface UserService {
	
	public void save(User user);
	public User register(User user);
	public User getUserById(Long id);

}
