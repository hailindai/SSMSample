package com.dreamguard.domain;

public class Person {
	
	public Person() {
		System.out.println("�˴�����");
	}
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
	
}
