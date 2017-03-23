package com.coderovers.makesurvey.service;

import com.coderovers.makesurvey.domain.User;

/**
 * @author Manish Karki
 * 
 */

public interface UserService {
	
	public void save(User user);
	public void register(User user);
	public User getUserById(Long id);

}
