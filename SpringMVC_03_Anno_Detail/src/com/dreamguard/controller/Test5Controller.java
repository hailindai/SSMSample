package com.dreamguard.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * session exception
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/session")
@SessionAttributes("attr1")//写入到session
public class Test5Controller {
	
	/**
	 * 传统方式
	 * @return
	 */
	@RequestMapping("/test1.action")
	public String test1(HttpSession session,Model model){
		session.setAttribute("attr1","session");
		return "first"; //返回String
	}
	
	/**
	 * 在class上声明session字段
	 * @return
	 */
	@RequestMapping("/test2.action")
	public String test2(Model model){
		model.addAttribute("attr1","session");
		return "first"; //返回String
	}

	@ModelAttribute
	public String getName(){
		return "dhl";
	}
	/**
	 * ModelAttribute
	 * 被修饰的方法将会在当前类的任意handler方法执行之前执行，该方法返回的返回值会自动存入model供后续使用
	 */
	@RequestMapping("/test3.action")
	public String test3(Model model, @ModelAttribute String username){
		model.addAttribute("attr1",username);
		return "first"; //返回String
	}
	
	
	/**
	 * 为Controller配置异常处理
	 * @param e
	 * @return
	 */
	//@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e){
		System.out.println("controller注解，出异常了"+e);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("attr1", e);
		modelAndView.setViewName("first");
		return modelAndView;
	}
	
	/**
	 * 
	 * 异常处理
	 * 1 controller 异常处理
	 * 2 全局异常处理
	 * 3 配置文件方式，配置全局错误处理
	 */
	@RequestMapping("/test4.action")
	public String test4(){
		int i=1/0;
		return "first"; //返回String
	}
}
