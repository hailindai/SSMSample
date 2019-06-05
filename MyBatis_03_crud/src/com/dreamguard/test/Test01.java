package com.dreamguard.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.dreamguard.domain.User;

public class Test01 {
	
	SqlSession session;
	@Before
	public void before() throws IOException{
		//1.读取Mybatis核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.创建SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.创建SqlSession
		session = factory.openSession();
	}
	
	/**
	 * update
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception{
		User user = new User(4,"ddd",16);
		session.update("com.dreamguard.mapper.UserMapper.update01", user);
		session.commit();
	}
	
	/**
	 * select 
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception{
		User user = new User(0,"dhl",16);
		List<User> list = session.selectList("com.dreamguard.mapper.UserMapper.select01", user);
		System.out.println(list);
	}
	/**
	 * insert
	 * @throws Exception
	 */
	@Test
	public void test03() throws Exception{
		User user = new User(0,"dhl",16);
		session.insert("com.dreamguard.mapper.UserMapper.insert01", user);
		session.commit();
	}
	
	/**
	 * delete
	 * @throws Exception
	 */
	@Test
	public void test04() throws Exception{
		User user = new User(0,"dhl",0);
		session.delete("com.dreamguard.mapper.UserMapper.delete01", user);
		session.commit();
	}
	
	/**
	 * 映射结果集 
	 * @throws Exception
	 */
	@Test
	public void test05() throws Exception{
		List<User> list = session.selectList("com.dreamguard.mapper.UserMapper.select02");
		System.out.println(list);
	}
	
}
