package com.coderovers.makesurvey.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.coderovers.makesurvey.domain.User;

/**
 * @author Manish Karki
 * 
 */
@Repository
public interface UserRepository extends CrudRepository<User, Long> {
	
	User findByEmail(String email);
	User findByUserName(String userName);
	@Query("select u from User u where u.createdByUser = :username")
	List<User> findTakers(@Param("username") String username);

}
