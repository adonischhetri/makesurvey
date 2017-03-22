package com.coderovers.makesurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.repository.UserRepository;
import com.coderovers.makesurvey.service.UserService;

/**
 * @author Manish Karki
 * 
 */
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findOne(id);
	}

}
