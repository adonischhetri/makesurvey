package com.coderovers.makesurvey.service.impl;

import java.util.HashSet;
import java.util.Set;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
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
@Service("myUserService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RolesRepository roleRepository;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public void save(User user) {
		userRepository.save(user);

	}

	@Override
	public User getUserById(Long id) {
		
		return userRepository.findOne(id);
	}

	@Override
	public User register(User user, String role) {
		Set<Roles> roleSet = new HashSet<Roles>();
		if(roleRepository.findByType(role) != null){
			Roles roles = roleRepository.findByType(role);
			roleRepository.save(roles);
//			roles.setType("CREATOR");
			System.out.println(roles+" yo ho roles aako db bata");
			roleSet.add(roles);
		}
		user.setPassword(passwordEncoder.encode(user.getPassword()));
		user.setRoles(roleSet);
		return userRepository.save(user);
	}

}
