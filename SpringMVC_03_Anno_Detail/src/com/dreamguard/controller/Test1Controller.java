package com.dreamguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 限定匹配条件
 */
@Controller
@RequestMapping("/test1")	//指定父路径
public class Test1Controller {
	/*--------------value---------------*/
	@RequestMapping("/test1.action")//指定映射到哪些路径，可以用通配符和placeholder
	public void test1(){
		System.out.println("指定映射到哪些路径");
	}
	/*--------------value---------------*/
	
	
	/*--------------method---------------*/
	@RequestMapping(value="/test2.action",method={RequestMethod.GET}) //限定请求方式
	public void test2(){
		System.out.println("限定请求方式");
	}
	/*--------------method---------------*/
	
	
	/*--------------params---------------*/
	@RequestMapping(value="/test3.action",params={"username"}) //限定必须有请求参数
	public void test3(){
		System.out.println("限定必须有请求参数");
	}
	
	@RequestMapping(value="/test4.action",params={"username=dhl"}) //限定必须有请求参数
	public void test4(){
		System.out.println("限定必须有请求参数,且值为dhl");
	}
	
	@RequestMapping(value="/test5.action",params={"!username"}) //限定必须有没有指定请求参数
	public void test5(){
		System.out.println("限定必须没有指定请求参数");
	}
	/*--------------params---------------*/
	
	
	/*--------------headers---------------*/
	//类似param
	@RequestMapping(value="/test6.action",headers={"host"}) //限定必须有指定请求头
	public void test6(){
		System.out.println("限定必须有指定请求头");
	}
	/*--------------headers---------------*/
}
