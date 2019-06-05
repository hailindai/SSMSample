package com.dreamguard.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

/**
 * 4 ±‡–¥¥¶¿Ì∆˜
 * @author Administrator
 *
 */
public class FirstController implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("attr1","val1");
		modelAndView.addObject("attr2","val2");
		modelAndView.addObject("attr3","val3");
		modelAndView.setViewName("first");
		return modelAndView;
	}

}
