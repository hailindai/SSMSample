package com.dreamguard.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class Test01 {
	@Test
	public void test01() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		
	}
}
