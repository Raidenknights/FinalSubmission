package com.example.MyWeb.UserService.UserModel;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

	@Autowired 
	private UserRegistrationRepository userRegRepo;

	public ResponseEntity<Object> createUser(String email, String password, UserModel user) {
		user.setEmail(email);
		user.setPass(password);
		user.setTimeStamp(new Date());
		userRegRepo.save(user);
		return  new ResponseEntity("Congrats now you can LogIn",HttpStatus.CREATED);
	}


	public ResponseEntity<Object> getAllUsers() {

		return  new ResponseEntity(userRegRepo.findAll(),HttpStatus.OK);
	}


	public ResponseEntity<Object> findUserById(String email) {
		UserModel userModel = userRegRepo.findByEmail(email);
		if(userModel==null) {
			throw new UserNotFound("No user with emailID:"+email);
		}
		return new ResponseEntity(userModel,HttpStatus.FOUND);
	}



	public ResponseEntity<Object> deleteUser(String email, String password) {

		UserModel userModel = userRegRepo.findByEmail(email);
		if(userModel==null) {
			throw new UserNotFound("Either email id or Password is not correct");
		}
		if(userModel.getPass().equals(password)) {
			userRegRepo.delete(userModel);
		}
		else {
			throw  new WrongCredentials("Either email id or Password is not correct");
		}
		return new ResponseEntity("We have deleted your account permanently",HttpStatus.ACCEPTED);	
	}


	public ResponseEntity<Object> updateUser(String email, String oldPassword, String newPassword) {
		UserModel userModel = userRegRepo.findByEmail(email);
		if(userModel==null || userModel.getPass().equals(oldPassword)==false) {
			throw new WrongCredentials("Either email id or Password is not correct");
		}
		userModel.setPass(newPassword);
		userRegRepo.save(userModel);
		return new ResponseEntity("Password has been updated",HttpStatus.OK);
	}

}
