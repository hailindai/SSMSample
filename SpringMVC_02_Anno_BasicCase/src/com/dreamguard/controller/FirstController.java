package com.dreamguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


/**
 * ��д������
 * @author Administrator
 *
 */
@Controller
public class FirstController{

	@RequestMapping("/first.action")
	public ModelAndView firstAnno(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("attr1","first");//��ӵ�������
		modelAndView.setViewName("first");//ָ����ͼ����
		return modelAndView;
	}
	
	@RequestMapping("/second.action")
	public String secondAnno(Model model){
		model.addAttribute("attr1", "second");
		return "second";//ָ����ͼ����
	}
	
	//����Ĭ����ͼthird.jsp
	@RequestMapping("/third.action")
	public void thirdAnno(Model model){
		model.addAttribute("attr1", "third");
	}

}
