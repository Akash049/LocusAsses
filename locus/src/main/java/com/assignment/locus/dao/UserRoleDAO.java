package com.assignment.locus.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.locus.model.User;
import com.assignment.locus.model.UserRole;
import com.assignment.locus.repository.UserRoleRepository;

@Service
public class UserRoleDAO {
	
	@Autowired
	UserRoleRepository userRoleRepository;
	
	/*Check if a user with given user role exists*/
	public List<UserRole> getUserRoleStatus(String username, String role) {
		return userRoleRepository.getRoleStatus(username,role);
	}
	
	/*Check if user is admin*/
	public boolean checkIfAdmin(String user_id) {
		if( userRoleRepository.checkIfAdmin(user_id) > 0) {
			return true;
		}else {
			return false;
		}
	}
	
	/*Add a user role*/
	public UserRole addRole(UserRole userRole) {
		return userRoleRepository.save(userRole);
	}
	
	/*Delete a user role*/
	public Boolean removeRole(String username, String role) {
		try {
			userRoleRepository.removeRole(username, role);
			return true;
		}catch(Exception e) {
			return false;
		}
	}
	
}
