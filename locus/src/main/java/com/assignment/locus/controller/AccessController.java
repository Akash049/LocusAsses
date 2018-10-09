package com.assignment.locus.controller;

import java.util.List;

import javax.validation.Valid;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.locus.dao.AccessDAO;
import com.assignment.locus.model.Access;
import com.assignment.locus.model.User;
import com.assignment.locus.model.UserResourceAccessResponse;

@RestController
@RequestMapping("/resourceaccess")
public class AccessController {

	@Autowired
	AccessDAO accessdao;
	
	/*To save an access role*/
	@PostMapping("/role")
	public Access createRole(@Valid @RequestBody Access access) {
		return accessdao.createAccess(access);
	}
	
	/*Get all access*/
	@GetMapping("/role")
	public List<Access> getAllAccess(){
		return accessdao.findAll();
	}
	
	/*Check Access for User-Resource*/
	@PostMapping("/checkaccess")
	public UserResourceAccessResponse checkAccessForUserResource(@Valid @RequestBody String body) {
		
		UserResourceAccessResponse response = new UserResourceAccessResponse();
		
		try {
			JSONObject json=new JSONObject(body);
			String user_id = json.optString("user_id");
			String resource = json.optString("resource");
			String accesstype = json.optString("accesstype");
			if(accessdao.checkRoleForUserResource(user_id, resource, accesstype) >= 1 ) {
				response.setStatus("ACCESS ALLOWED");
			}else {
				response.setStatus("ACCESS NOT ALLOWED");
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.setStatus("COULD NOT GET STATUS");
		}
		return response;
	}
}
