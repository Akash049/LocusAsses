package com.assignment.locus.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.locus.model.User;
import com.assignment.locus.repository.UserRepository;

@Service
public class UserDAO {

	@Autowired
	UserRepository userRepository;
	
	/*Create a user*/
	public User createUser(User user) {
		return userRepository.save(user);
	}
	
	/*Get all the user*/
	public List<User> findAll(){
		return userRepository.findAll();
	}
	
	/*Find the user by id*/
	public User findOneById(Long id) {
		return userRepository.findOne(id);
	}
	
	/*Get the role details of the user*/
	
	/*Delete the role of a user*/
	public void deleteOne(User user) {
		userRepository.delete(user);
	}
	
	/*Update the role of a user*/
	public User updateOne(User user) {
		return userRepository.save(user);
	}
	
	/*Check if user exists*/
	
	
	/*Get all admins*/
	public List<User> getAdmins(){
		return userRepository.findAdmins();
	}
	
}
