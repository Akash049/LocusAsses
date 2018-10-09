package com.assignment.locus.repository;

import com.assignment.locus.model.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

public interface UserRepository extends JpaRepository<User, Long>{

	@Query(value="SELECT * FROM USER WHERE roles = 'Admin'", nativeQuery = true)
	List<User> findAdmins();
	
}
