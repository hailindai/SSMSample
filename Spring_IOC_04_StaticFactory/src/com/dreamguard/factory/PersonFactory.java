package com.dreamguard.factory;

import com.dreamguard.domain.Person;

public class PersonFactory {
	public static Person getPerson(){
		return new Person();
	}
}
