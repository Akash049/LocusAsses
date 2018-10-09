package com.assignment.locus.model;

import java.util.List;

public class UserRoleResponse {

	private String status;
	public String getStatus() {
		return status;
	}
	
	public UserRoleResponse() {
		super();
	}

	public void setStatus(String status) {
		this.status = status;
	}
	public List<UserRole> getUserRole() {
		return userRole;
	}
	public void setUserRole(List<UserRole> userRole) {
		this.userRole = userRole;
	}
	private List<UserRole> userRole;
}
