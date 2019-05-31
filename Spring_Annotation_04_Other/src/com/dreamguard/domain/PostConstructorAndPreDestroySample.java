package com.dreamguard.domain;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

@Component
public class PostConstructorAndPreDestroySample {
	@PostConstruct
	public void init(){
		System.out.println("init");
	}
	@PreDestroy
	public void destroy(){
		System.out.println("destroy");
	}
}
