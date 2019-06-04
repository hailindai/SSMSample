package com.dreamguard.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.dreamguard.dao.UserDao;
import com.dreamguard.domain.User;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao = null;
	@Override
	@Transactional
	public void registerUser(User user) {
		System.out.println("UserService register " + user);
		userDao.addUser(user);
		int i=1/0;

	}

	@Override
	@Transactional(rollbackFor=Throwable.class)
	public void updateUser(User user) {
		System.out.println("UserService updateUser " + user);

	}

	@Override
	public void deleteUser(int id) {
		System.out.println("UserService deleteUser " + id);

	}

	@Override
	@Transactional(propagation=Propagation.NOT_SUPPORTED)
	public User queryUser(int id) {
		// TODO Auto-generated method stub
		System.out.println("UserService queryUser " + id);
		userDao.queryUserById(1);
		return new User(1,"zs","123","123@qq.com");
	}

}
