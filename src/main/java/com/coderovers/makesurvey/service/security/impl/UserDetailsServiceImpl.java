package com.coderovers.makesurvey.service.security.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import com.coderovers.makesurvey.domain.Roles;
import com.coderovers.makesurvey.domain.User;
import com.coderovers.makesurvey.repository.UserRepository;


public class UserDetailsServiceImpl implements UserDetailsService{
	@Autowired
	private UserRepository userRepository;

	@Override
	@Transactional(readOnly =true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUserName(username);
		
		if(user==null){
			System.out.println("User not found");
			throw new UsernameNotFoundException("User not found");
		}else{
			System.out.println(user.getUserName());
		}
		return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(), true, true, true, true, getGrantedAuthorities(user));
	}

	private Collection<GrantedAuthority> getGrantedAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		for(Roles role: user.getRoles()){
			System.out.println(role);
			authorities.add(new SimpleGrantedAuthority("ROLE_"+role.getType()));
		}
		System.out.println(authorities);
		return authorities;
	}

}
