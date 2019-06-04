package com.dreamguard.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.dreamguard.domain.User;
import com.dreamguard.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService = null;
	
	public void registerUser(User user){
		userService.registerUser(user);
	}
	
	public void updateUser(User user){
		userService.updateUser(user);
	}
	
	public void deleteUser(int id){
		userService.deleteUser(id);
	}
	
	public User queryUser(int id){
		return userService.queryUser(id);
	}
}
