package com.coderovers.makesurvey.service;

import com.coderovers.makesurvey.domain.Roles;

/**
 * @author Manish Karki
 * 
 */

public interface RoleService {
	
	Roles getRoleByType(String type);

}
