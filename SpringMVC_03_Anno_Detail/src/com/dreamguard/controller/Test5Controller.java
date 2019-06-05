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
@SessionAttributes("attr1")//д�뵽session
public class Test5Controller {
	
	/**
	 * ��ͳ��ʽ
	 * @return
	 */
	@RequestMapping("/test1.action")
	public String test1(HttpSession session,Model model){
		session.setAttribute("attr1","session");
		return "first"; //����String
	}
	
	/**
	 * ��class������session�ֶ�
	 * @return
	 */
	@RequestMapping("/test2.action")
	public String test2(Model model){
		model.addAttribute("attr1","session");
		return "first"; //����String
	}

	@ModelAttribute
	public String getName(){
		return "dhl";
	}
	/**
	 * ModelAttribute
	 * �����εķ��������ڵ�ǰ�������handler����ִ��֮ǰִ�У��÷������صķ���ֵ���Զ�����model������ʹ��
	 */
	@RequestMapping("/test3.action")
	public String test3(Model model, @ModelAttribute String username){
		model.addAttribute("attr1",username);
		return "first"; //����String
	}
	
	
	/**
	 * ΪController�����쳣����
	 * @param e
	 * @return
	 */
	//@ExceptionHandler
	public ModelAndView exceptionHandler(Exception e){
		System.out.println("controllerע�⣬���쳣��"+e);
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("attr1", e);
		modelAndView.setViewName("first");
		return modelAndView;
	}
	
	/**
	 * 
	 * �쳣����
	 * 1 controller �쳣����
	 * 2 ȫ���쳣����
	 * 3 �����ļ���ʽ������ȫ�ִ�����
	 */
	@RequestMapping("/test4.action")
	public String test4(){
		int i=1/0;
		return "first"; //����String
	}
}
