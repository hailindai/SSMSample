package com.dreamguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/forward")
public class Test4Controller {
	
	/**
	 * 请求转发
	 * @return
	 */
	@RequestMapping("test1.action")
	public String test1(){
		System.out.println("test1");
		return "forward:/test1/test1.action";
	}
	
	/**
	 * 请求重定向
	 * @return
	 */
	@RequestMapping("test2.action")
	public String test2(){
		System.out.println("test2");
		return "redirect:/test1/test1.action";
	}
}
