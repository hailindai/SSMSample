package com.dreamguard.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.domain.Hero;


public class Test01 {
	@Test
	public void test01() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		Hero hero = (Hero) applicationContext.getBean("hero");
		System.out.println(hero);
	}
}
