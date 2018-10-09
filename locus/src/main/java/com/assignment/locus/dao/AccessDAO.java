package com.assignment.locus.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.locus.model.Access;
import com.assignment.locus.model.User;
import com.assignment.locus.repository.AccessRepository;

@Service
public class AccessDAO {
	
	@Autowired
	AccessRepository accessRepository;
	
	/*Create a access role access*/
	public Access createAccess(Access access) {
		return accessRepository.save(access);
	}

	/*Get all the roles access*/
	public List<Access> findAll(){
		return accessRepository.findAll();
	}
	
	/*Check if access present*/
	public Integer checkRoleForUserResource(String user_id, String resource ,String accesstype) {
		return accessRepository.checkIfRolePresent(user_id, resource, accesstype);
	}
	
}
