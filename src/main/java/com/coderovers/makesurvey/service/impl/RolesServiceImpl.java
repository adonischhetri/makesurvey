package com.coderovers.makesurvey.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.coderovers.makesurvey.domain.Roles;
import com.coderovers.makesurvey.repository.RolesRepository;
import com.coderovers.makesurvey.service.RoleService;

/**
 * @author Manish Karki
 * 
 */

@Service
@Transactional
public class RolesServiceImpl implements RoleService {
	
	@Autowired
	private RolesRepository roleRepository; 

	@Override
	public Roles getRoleByType(String type) {
		return roleRepository.findByType(type);
	}

}
