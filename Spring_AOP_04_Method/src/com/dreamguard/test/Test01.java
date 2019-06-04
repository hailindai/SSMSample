package com.dreamguard.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.domain.User;
import com.dreamguard.web.UserController;

public class Test01 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController userController = context.getBean(UserController.class);
		
		userController.queryUser(1);
	}

}
