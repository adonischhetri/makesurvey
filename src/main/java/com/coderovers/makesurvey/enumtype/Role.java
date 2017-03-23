package com.coderovers.makesurvey.enumtype;

/**
 * @author Manish Karki
 * 
 */

public enum Role {
	CREATOR("CREATOR"), ADMIN("ADMIN");
	String role;

	private Role(String role) {
		this.role = role;
	}

	public String getRole() {
		return role;
	}
}
