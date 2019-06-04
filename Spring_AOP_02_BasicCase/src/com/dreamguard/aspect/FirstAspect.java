package com.dreamguard.aspect;

import org.springframework.stereotype.Component;

@Component
public class FirstAspect {
	public void before(){
		System.out.println("FirstAspect中的before执行了");
	}
}
