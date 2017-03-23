package com.coderovers.makesurvey.service;
public interface SecurityService {
	String findLoggedInUsername();
	
	void autoLogin(String username, String password);
	
	boolean isGuest();

}
