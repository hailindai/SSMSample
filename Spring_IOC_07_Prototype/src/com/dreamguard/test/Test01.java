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
		/**
		 * 通过打印结果可以看到：
		 * 		两个Person地址相同：单例
		 * 		两条狗地址不同：多例
		 */
		Person person = (Person)context.getBean("person");
		System.out.println(person);
		Person person2 = (Person)context.getBean("person");
		System.out.println(person2);
		
		Dog dog = (Dog)context.getBean("dog");
		System.out.println(dog);
		Dog dog2 = (Dog)context.getBean("dog");
		System.out.println(dog2);
	}
}
