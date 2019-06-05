package com.dreamguard.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.dreamguard.domain.User;
import com.dreamguard.mapper.UserMapper;

public class Test01 {

	
	/**
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception{

		//1.��ȡMybatis���������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.����SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.����SqlSession
		SqlSession session = factory.openSession();
		
		UserMapper mapper = session.getMapper(UserMapper.class);
		System.out.println(mapper.queryAll());
		System.out.println(mapper.queryById(3));
	}
}
