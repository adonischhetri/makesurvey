package com.coderovers.makesurvey.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderovers.makesurvey.domain.Roles;
import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.repository.RolesRepository;
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
	
	@Autowired
	private RolesRepository roleRepository;
	
	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public void register(User user) {
		Set<Roles> roleSet = new HashSet<Roles>();
		//System.out.println("role:"+roleRepository.findByType("CREATOR").getType());
		//roleSet.add(roleRepository.findByType("CREATOR"));
		user.setRoles(roleSet);
		userRepository.save(user);
	}

}
