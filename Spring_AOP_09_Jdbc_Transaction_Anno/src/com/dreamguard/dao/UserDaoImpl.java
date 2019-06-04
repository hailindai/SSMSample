package com.dreamguard.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dreamguard.domain.User;
import com.dreamguard.util.JdbcUtil;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	private JdbcTemplate jdbcTemplate = null;
	
	@Override
	public User queryUserById(int id) {
		// TODO Auto-generated method stub
		JdbcUtil.print(JdbcUtil.select("select * from user where id=?",id));
		return null;
	}

	@Override
	public void addUser(User user) {
		jdbcTemplate.update("insert into user values(null,?,?,?,?)",user.getUsername(),user.getPassword(),user.getUsername(),user.getEmail());
	}

}
