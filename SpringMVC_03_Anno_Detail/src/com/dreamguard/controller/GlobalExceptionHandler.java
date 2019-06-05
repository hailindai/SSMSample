package com.dreamguard.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

//@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e){
		System.out.println("全局注解，出异常了"+e);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("attr1", e);
		modelAndView.setViewName("first");
		return modelAndView;
	}
}
