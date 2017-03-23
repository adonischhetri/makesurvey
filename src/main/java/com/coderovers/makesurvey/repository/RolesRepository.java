package com.coderovers.makesurvey.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coderovers.makesurvey.domain.Roles;

/**
 * @author Manish Karki
 * 
 */

@Repository
public interface RolesRepository extends JpaRepository<Roles, Integer> {
	
	Roles findByType(String type);

}
