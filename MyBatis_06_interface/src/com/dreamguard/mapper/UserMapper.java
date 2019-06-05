package com.dreamguard.mapper;

import java.util.List;

import com.dreamguard.domain.User;

public interface UserMapper {
	List<User> queryAll();
	User queryById(int id);
}
