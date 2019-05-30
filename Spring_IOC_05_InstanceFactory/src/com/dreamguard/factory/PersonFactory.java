package com.dreamguard.factory;

import com.dreamguard.domain.Person;

public class PersonFactory {
	public Person getPerson(){
		return new Person();
	}
}
