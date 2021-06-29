package com.example.MyWeb.UserService.UserModel;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

@Service
public interface UserService {
		ResponseEntity<Object> createUser(String email,String password,@RequestBody UserModel user);
		ResponseEntity<Object> getAllUsers();
		ResponseEntity<Object> findUserById(String email);
		ResponseEntity<Object> deleteUser(String email,String password);
		ResponseEntity<Object> updateUser(String email,String oldPassword,String newPassword);
}
