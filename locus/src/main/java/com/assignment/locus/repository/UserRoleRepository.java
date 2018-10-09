package com.assignment.locus.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
import org.springframework.data.repository.query.Param;

import com.assignment.locus.model.UserRole;

public interface UserRoleRepository extends JpaRepository<UserRole, Long>{

	@Query(value ="SELECT * FROM User_Role WHERE roles = ?2 AND user_id = ?1 ", nativeQuery = true)
	public List<UserRole> getRoleStatus(String user_id, String role );
	
	@Query(value ="DELETE FROM User_Role WHERE user_id = ?1 AND roles = ?2", nativeQuery = true)
	public void removeRole(String user_id, String role );
	
	@Query(value ="SELECT COUNT(*) FROM User_Role WHERE user_id = ?1 AND roles = 'admin'", nativeQuery = true)
	public Integer checkIfAdmin(String user_id);
	
}
