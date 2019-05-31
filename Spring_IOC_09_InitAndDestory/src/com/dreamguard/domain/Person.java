package com.dreamguard.domain;

public class Person {
	private String name;

	
	public void init(){
		System.out.println("³õÊ¼»¯");
	}
	public void destroy(){
		System.out.println("Ïú»Ù");
	}
	
	
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
