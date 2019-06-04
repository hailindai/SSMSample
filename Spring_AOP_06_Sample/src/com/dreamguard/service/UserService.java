package com.dreamguard.service;

import com.dreamguard.anno.Priv;
import com.dreamguard.anno.PrivEnum;
import com.dreamguard.domain.User;

public interface UserService {
	void registerUser(User user);
	
	void updateUser(User user);
	
	void deleteUser(int id);
	
	User queryUser(int id);

}
