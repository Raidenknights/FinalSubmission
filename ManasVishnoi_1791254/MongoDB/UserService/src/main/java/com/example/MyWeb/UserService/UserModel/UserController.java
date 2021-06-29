package com.example.MyWeb.UserService.UserModel;

import javax.validation.Valid;
import javax.validation.constraints.Email;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	
	@Autowired
	private UserService service;
	
	@PostMapping(path="/signup")
	public ResponseEntity<Object> createNewUser(@Email @RequestParam String email,@Valid @RequestParam String password,
			@RequestBody UserModel usermod){
	return	service.createUser(email, password, usermod);
	}
	
	
	@GetMapping(path="/getUsers")
	public ResponseEntity<Object> getUsers(){
		return service.getAllUsers();
	}
	
	@GetMapping(path ="/userDetails")
	public ResponseEntity<Object> getUserDetails(@Email @RequestParam String email){
		
		return service.findUserById(email);
	}
	
	
	@DeleteMapping(path="deleteUser")
	public ResponseEntity<Object> deleteUser(@Email @RequestParam String email,@RequestParam String password){
		
			return service.deleteUser(email, password);
	}
	
	@PutMapping(path="updateUser")
	public ResponseEntity<Object> updateUser(@Email @RequestParam String email, @RequestParam String oldPassword,@RequestParam String
			newPassword){
		return service.updateUser(email, oldPassword, newPassword);
	}
}
