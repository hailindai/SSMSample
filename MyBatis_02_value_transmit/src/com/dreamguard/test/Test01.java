package com.dreamguard.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	 * Map 传值
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception{
		Map<String, Integer> map = new HashMap<>();
		map.put("min", 30);
		map.put("max", 40);
		//4.执行操作
		List<User> list = session.selectList("com.dreamguard.mapper.UserMapper.query01",map);
		//5.遍历结果
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	/**
	 * 对象 传值
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception{
		User user = new User(0,"fff",27);
		//session.insert("com.dreamguard.mapper.UserMapper.insert01",user);
		session.commit();//更新默认带事务
	}
	
	/**
	 * 单值传值
	 * @throws Exception
	 */
	@Test
	public void test03() throws Exception{
		//4.执行操作
		User user = session.selectOne("com.dreamguard.mapper.UserMapper.query02",3);
		//5.结果
		System.out.println(user);
	}
	
	/**
	 * 	#和$的区别
	 * @throws Exception
	 */
	@Test
	public void test04() throws Exception{
		//4.执行操作
		Map<String, String> map = new HashMap<>();
		map.put("name", "ccc");
		User user = session.selectOne("com.dreamguard.mapper.UserMapper.query03",map);
		//5.结果
		System.out.println(user);
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("age", "age");
		//4.执行操作
		List<User> list = session.selectList("com.dreamguard.mapper.UserMapper.query04",map2);
		//5.遍历结果
		System.out.println(list);
	}
	
}
