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
		//1.��ȡMybatis���������ļ�
		InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
		//2.����SqlSessionFactory
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		//3.����SqlSession
		session = factory.openSession();
	}
	
	/**
	 * Map ��ֵ
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception{
		Map<String, Integer> map = new HashMap<>();
		map.put("min", 30);
		map.put("max", 40);
		//4.ִ�в���
		List<User> list = session.selectList("com.dreamguard.mapper.UserMapper.query01",map);
		//5.�������
		System.out.println(Arrays.toString(list.toArray()));
	}
	
	/**
	 * ���� ��ֵ
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception{
		User user = new User(0,"fff",27);
		//session.insert("com.dreamguard.mapper.UserMapper.insert01",user);
		session.commit();//����Ĭ�ϴ�����
	}
	
	/**
	 * ��ֵ��ֵ
	 * @throws Exception
	 */
	@Test
	public void test03() throws Exception{
		//4.ִ�в���
		User user = session.selectOne("com.dreamguard.mapper.UserMapper.query02",3);
		//5.���
		System.out.println(user);
	}
	
	/**
	 * 	#��$������
	 * @throws Exception
	 */
	@Test
	public void test04() throws Exception{
		//4.ִ�в���
		Map<String, String> map = new HashMap<>();
		map.put("name", "ccc");
		User user = session.selectOne("com.dreamguard.mapper.UserMapper.query03",map);
		//5.���
		System.out.println(user);
		
		Map<String, String> map2 = new HashMap<>();
		map2.put("age", "age");
		//4.ִ�в���
		List<User> list = session.selectList("com.dreamguard.mapper.UserMapper.query04",map2);
		//5.�������
		System.out.println(list);
	}
	
}
