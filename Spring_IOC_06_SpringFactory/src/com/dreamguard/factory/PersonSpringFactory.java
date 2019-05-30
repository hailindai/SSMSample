package com.dreamguard.factory;

import org.springframework.beans.factory.FactoryBean;

import com.dreamguard.domain.Person;

public class PersonSpringFactory implements FactoryBean<Person> {

	@Override
	public Person getObject() throws Exception {
		// TODO Auto-generated method stub
		return new Person();
	}

	@Override
	public Class<?> getObjectType() {
		// TODO Auto-generated method stub
		return Person.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

}
