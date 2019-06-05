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

public class Test01 {

	
	/**
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception{

		//1.读取Mybatis核心配置文件
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.创建SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.创建SqlSession
		SqlSession session = factory.openSession();
		//4.执行操作
		List<User> list = session.selectList("com.dreamguard.mapper.UserMapper.queryAll");
		//5.遍历结果
		System.out.println(list);
	}
}
