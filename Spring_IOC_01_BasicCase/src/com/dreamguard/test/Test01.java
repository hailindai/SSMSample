package com.dreamguard.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dreamguard.domain.Person;

public class Test01 {
	public static void main(String[] args) {
		//1.��ʼ��Spring����
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.ͨ��Spring������ȡ����
		Person person = (Person)context.getBean("person");
		person.print();
	}
}
