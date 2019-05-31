package com.dreamguard.test;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.domain.Person;

public class Test01 {
	@Test
	public void test01() throws Exception {
		//close函数存在于ClassPathXmlApplicationContext中，所以此处使用ClassPathXmlApplicationContext
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Person person = (Person)context.getBean("person");
		System.out.println(person);
		context.close();
	}
}
