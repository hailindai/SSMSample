package com.dreamguard.test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import com.dreamguard.domain.Dept;
import com.dreamguard.domain.Emp;
import com.dreamguard.domain.Grade;
import com.dreamguard.domain.Teacher;

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
	 * 一对一
	 * @throws Exception
	 */
	@Test
	public void test01() throws Exception{
		List<Grade> list = session.selectList("com.dreamguard.mapper.comMapper.queryO2O");
		System.out.println(list);
	}
	
	
	/**
	 * 一对多,部门角度
	 * @throws Exception
	 */
	@Test
	public void test02() throws Exception{
		List<Dept> list = session.selectList("com.dreamguard.mapper.comMapper.queryO2M");
		System.out.println(list);
	}
	
	/**
	 * 多对一,员工角度
	 * @throws Exception
	 */
	@Test
	public void test03() throws Exception{
		List<Emp> list = session.selectList("com.dreamguard.mapper.comMapper.queryM2O");
		System.out.println(list);
	}
	
	/**
	 * 多对多
	 * @throws Exception
	 */
	@Test
	public void test04() throws Exception{
		List<Teacher> list = session.selectList("com.dreamguard.mapper.comMapper.queryM2M");
		System.out.println(list);
	}
}
