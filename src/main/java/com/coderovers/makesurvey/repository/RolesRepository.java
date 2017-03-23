package com.coderovers.makesurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderovers.makesurvey.domain.Roles;
import com.coderovers.makesurvey.enumtype.Role;

/**
 * @author Manish Karki
 * 
 */

@Repository
public interface RolesRepository extends JpaRepository<Roles, Long> {
	
	Roles findByRole(Role role);

}
