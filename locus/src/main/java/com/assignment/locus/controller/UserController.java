package com.assignment.locus.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.locus.model.User;
import com.assignment.locus.repository.UserRepository;

import com.assignment.locus.dao.UserDAO;

@RestController
@RequestMapping("/access")
public class UserController {

	@Autowired
	UserDAO userdoa;
	
	/*To save a user*/
	@PostMapping("/user")
	public User createUser(@Valid @RequestBody User user) {
		return userdoa.createUser(user);
	}
	
	/*Get all user*/
	@GetMapping("/user")
	public List<User> getAllUser(){
		return userdoa.findAll();
	}
	
	/*Get user by id */
	@GetMapping("/user/{id}")
	public ResponseEntity<User> getAllUser(@PathVariable(value="id") Long id){
		System.out.println("Id: "+id);
		User user = userdoa.findOneById(id);
		if( user == null ) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(user);
	}
	
	/*Update the user id*/
	@PutMapping("/user/{id}")
	public ResponseEntity<User> updateEmployee(@PathVariable(value="id") Long id, @RequestBody User userDetails){
		User user = userdoa.findOneById(id);
		if( user == null ) {
			return ResponseEntity.notFound().build();
		}
		user.setUsername(userDetails.getUsername());
		user.setRoles(userDetails.getRoles());
		user.setPassword(userDetails.getPassword());
		
		User updatedUser = userdoa.updateOne(user);
		
		return ResponseEntity.ok().body(updatedUser);
	}
	
	/*Delete a User*/
	@DeleteMapping("/user/{id}")
	public ResponseEntity<User> userdelete( @PathVariable(value="id") Long id) {
		User user = userdoa.findOneById(id);
		if( user == null ) {
			return ResponseEntity.notFound().build();
		}
		userdoa.deleteOne(user);
		
		return ResponseEntity.ok().build();
	}
	
	/*Get all admins*/
	@GetMapping("/admins")
	public List<User> getAdmins(){
		return userdoa.getAdmins();
	}
	
	
}
