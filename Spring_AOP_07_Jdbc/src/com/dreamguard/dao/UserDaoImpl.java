package com.dreamguard.dao;

import org.springframework.stereotype.Repository;

import com.dreamguard.domain.User;
import com.dreamguard.util.JdbcUtil;

@Repository
public class UserDaoImpl implements UserDao {

	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		JdbcUtil.print(JdbcUtil.select("select * from user where id=?",id));
		return null;
	}

}
