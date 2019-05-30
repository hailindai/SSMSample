package com.dreamguard.test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.dreamguard.domain.Person;

public class Test01 {
	public static void main(String[] args) {
		//1.初始化Spring容器
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		//2.通过Spring容器获取对象
		Person person = (Person)context.getBean("person");
		person.print();
	}
}
