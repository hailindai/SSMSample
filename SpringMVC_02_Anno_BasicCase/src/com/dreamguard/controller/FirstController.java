package com.dreamguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * 编写处理器
 * @author Administrator
 *
 */
@Controller
public class FirstController{

	@RequestMapping("/first.action")
	public ModelAndView firstAnno(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("attr1","first");//添加到作用域
		modelAndView.setViewName("first");//指定视图名称
		return modelAndView;
	}
	
	@RequestMapping("/second.action")
	public String secondAnno(Model model){
		model.addAttribute("attr1", "second");
		return "second";//指定视图名称
	}
	
	//采用默认视图third.jsp
	@RequestMapping("/third.action")
	public void thirdAnno(Model model){
		model.addAttribute("attr1", "third");
	}

}
