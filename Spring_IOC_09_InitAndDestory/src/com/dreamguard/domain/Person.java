package com.dreamguard.domain;

public class Person {
	private String name;

	
	public void init(){
		System.out.println("��ʼ��");
	}
	public void destroy(){
		System.out.println("����");
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
