package com.assignment.locus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.assignment.locus.model.Access;
import com.assignment.locus.model.UserRole;


public interface AccessRepository extends JpaRepository<Access, Long>{

	@Query(value ="SELECT count(user_id) from User_Role WHERE user_id= ?1 AND roles IN (select roles from access where resource= ?2 and accesstype = ?3)", nativeQuery = true)
	public Integer checkIfRolePresent(String user_id, String resource ,String accesstype );
	
}
