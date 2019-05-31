package com.dreamguard.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.domain.Dog;
import com.dreamguard.domain.Person;

public class Test01 {
	@Test
	public void test01() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//ÀÁÈË
		Person person = (Person)context.getBean("person");
		System.out.println(person);
		//»ý¼«¹·
		Dog dog = (Dog)context.getBean("dog");
		System.out.println(dog);
	}
}
