package com.dreamguard.controller;

import org.springframework.stereotype.Component;

@Component
public class User {
	private String username;
	private String email;
	private Dog dog;
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Dog getDog() {
		return dog;
	}
	public void setDog(Dog dog) {
		this.dog = dog;
	}
}
