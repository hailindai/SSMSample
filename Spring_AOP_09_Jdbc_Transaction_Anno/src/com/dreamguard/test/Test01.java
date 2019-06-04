package com.dreamguard.test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.jdbc.core.RowMapper;

import com.dreamguard.domain.User;
import com.dreamguard.web.UserController;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class Test01 {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		UserController userController = context.getBean(UserController.class);
		userController.registerUser(new User(1,"ЮђПе","123","123@qq.com"));
		
	}
	

}
