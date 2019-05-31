package com.dreamguard.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.domain.Dog;
import com.dreamguard.domain.NBA;
import com.dreamguard.domain.Person;


public class Test01 {
	@Test
	public void test01() throws Exception {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
		//��ͨ
		Person person = (Person) applicationContext.getBean("person");
		System.out.println(person);
		//ȫ��д
		NBA nba = (NBA) applicationContext.getBean("NBA");
		System.out.println(nba);
		//�Զ�������
		Dog dog = (Dog) applicationContext.getBean("DogW");
		System.out.println(dog);
	}
}
