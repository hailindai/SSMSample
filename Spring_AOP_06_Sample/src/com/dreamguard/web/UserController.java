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
		try {
			userService.registerUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void updateUser(User user){
		try {
			userService.updateUser(user);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void deleteUser(int id){
		try {
			userService.deleteUser(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public User queryUser(int id){
		User user = null;
		try {
			user = userService.queryUser(id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return user;
	}
}
