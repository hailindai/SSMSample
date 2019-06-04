package com.dreamguard.dao;

import com.dreamguard.domain.User;

public interface UserDao {
	void addUser(User user);
	User queryUserById(int id);
}
