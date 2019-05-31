package com.dreamguard.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Dog {
	@Value("½ðÅÆÐ¡Íú²Æ")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Dog [name=" + name + "]";
	}
	
	
}
