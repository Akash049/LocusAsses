package com.assignment.locus.controller;

import java.util.List;


import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.locus.dao.UserRoleDAO;
import com.assignment.locus.model.OnlyStatusResponse;
import com.assignment.locus.model.User;
import com.assignment.locus.model.UserRole;
import com.assignment.locus.model.UserRoleDeleteResponse;
import com.assignment.locus.model.UserRoleResponse;

import net.minidev.json.parser.JSONParser;
import net.minidev.json.parser.ParseException;

@RestController
@RequestMapping("/roles")
public class UserRoleController {
	
	@Autowired
	UserRoleDAO userRoleDao;
	
	/*Check if admin*/
	@PostMapping("/checkifadmin")
	public OnlyStatusResponse checkIdAdmin(@Valid @RequestBody String body) {
		OnlyStatusResponse response = new OnlyStatusResponse();
		
		try {
			JSONObject json=new JSONObject(body);
			String user_id = json.optString("user_id");
			boolean check = userRoleDao.checkIfAdmin(user_id);
			if(check) {
				response.setStatus("TRUE"); 
			}else {
				response.setStatus("FALSE"); 
			}
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus("NO RESPONSE OBTAINED"); 
		}
		return response;
	}
	
	/*To save a user*/
	@PostMapping("/adduserrole")
	public UserRoleResponse addNewRole(@Valid @RequestBody String body) {
		System.out.println("User Id: "+body);
		UserRoleResponse resposne = new UserRoleResponse();
		try {
			JSONObject json=new JSONObject(body);
			String user_id = json.optString("user_id");
			String role = json.optString("role");
			String superuser = json.optString("superuser");
			
			if(userRoleDao.checkIfAdmin(superuser)) {
				List<UserRole> userRole = userRoleDao.getUserRoleStatus(user_id, role);
				
				if(userRole.size() > 0) {
					resposne.setStatus("User Role Already Present");
					resposne.setUserRole(userRole);
					return resposne;
				}else {
					UserRole u = new UserRole();
					u.setUser_id(user_id);
					u.setRoles(role);
					userRoleDao.addRole(u);
					userRole.add(u);
					resposne.setStatus("User Role Created");
					resposne.setUserRole(userRole);
					return resposne;
				}
			}else {
				resposne.setStatus("Superuser Not an Admin");
				resposne.setUserRole(null);
				return resposne;
			}
			
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resposne.setStatus("User Role Created");
			resposne.setUserRole(null);
			return resposne;
		}
	}
	
	@PostMapping("/deleterole")
	public UserRoleDeleteResponse deleteRole(@Valid @RequestBody String body) {
		System.out.println("User Id: "+body);
		UserRoleDeleteResponse resposne = new UserRoleDeleteResponse();
		try {
			JSONObject json=new JSONObject(body);
			String user_id = json.optString("user_id");
			String role = json.optString("role");
			String superuser = json.optString("superuser");
			
			if(userRoleDao.checkIfAdmin(superuser)) {
				
				if(userRoleDao.removeRole(user_id, role)) {
					resposne.setStatus("User Deleted");
				}else {
					resposne.setStatus("Could Not Delete User");
				}
				return resposne;
			}else {
				resposne.setStatus("Superuser Not an Admin");
				return resposne;
			}
		
			
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			resposne.setStatus("User Role Does Not Exists");
			return resposne;
		}
	}

}
