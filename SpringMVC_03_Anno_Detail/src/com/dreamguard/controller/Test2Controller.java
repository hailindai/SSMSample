package com.dreamguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * ����ֵ����
 */
@Controller
@RequestMapping("/returntype")
public class Test2Controller {

	/**
	 * modelAndView
	 * @return
	 */
	@RequestMapping("/test1.action")
	public ModelAndView test1(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("attr1","test1");//��ӵ�������
		modelAndView.setViewName("first");//ָ����ͼ����
		return modelAndView; //����modelAndView
	}
	
	/**
	 * String
	 * ֱ�ӷ�����ͼ������
	 * @return
	 */
	@RequestMapping("/test2.action")
	public String test2(Model model){
		model.addAttribute("attr1","test2");
		return "first"; //����String
	}
	
	/**
	 * void
	 * �������ֵ������void������Զ����غ͵�ǰ������·������ͬ����ͼ��
	 */
	@RequestMapping("/first.action")
	public void test3(ModelMap map){//model modelmap map
//		map.addAttribute("attr1","void");
		map.put("attr1","void");
	}
	
	/**
	 * ��������@ResponseBody����ʱ��Ĭ�Ͻ����صĶ���תΪjsonд�����
	 */
	@RequestMapping("/test4.action")
	@ResponseBody
	public User test4(){
		User user = new User();
		user.setUsername("dhl");
		user.setEmail("dhl@qq.com");
		Dog dog = new Dog();
		dog.setName("С����");
		user.setDog(dog);
		return user;
	}
	
	/**
	 * 	������֮�ⷵ�ص��κ����ݶ��ᱻ����ģ���е����������������ص���ͼ����ͬ�ڵ�ǰ������·����
	 */
	@RequestMapping("/test5.action")
	public User test5(){
		User user = new User();
		user.setUsername("dhl");
		user.setEmail("dhl@qq.com");
		Dog dog = new Dog();
		dog.setName("С����");
		user.setDog(dog);
		return user;
	}
	
	
}
