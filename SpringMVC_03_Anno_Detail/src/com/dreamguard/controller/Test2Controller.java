package com.dreamguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * 返回值类型
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
		modelAndView.addObject("attr1","test1");//添加到作用域
		modelAndView.setViewName("first");//指定视图名称
		return modelAndView; //返回modelAndView
	}
	
	/**
	 * String
	 * 直接返回视图的名称
	 * @return
	 */
	@RequestMapping("/test2.action")
	public String test2(Model model){
		model.addAttribute("attr1","test2");
		return "first"; //返回String
	}
	
	/**
	 * void
	 * 如果返回值类型是void，则会自动返回和当前处理器路径名相同的视图名
	 */
	@RequestMapping("/first.action")
	public void test3(ModelMap map){//model modelmap map
//		map.addAttribute("attr1","void");
		map.put("attr1","void");
	}
	
	/**
	 * 当方法被@ResponseBody修饰时，默认将返回的对象转为json写入输出
	 */
	@RequestMapping("/test4.action")
	@ResponseBody
	public User test4(){
		User user = new User();
		user.setUsername("dhl");
		user.setEmail("dhl@qq.com");
		Dog dog = new Dog();
		dog.setName("小旺财");
		user.setDog(dog);
		return user;
	}
	
	/**
	 * 	除以上之外返回的任何内容都会被当做模型中的数据来处理，而返回的视图名等同于当前处理器路径名
	 */
	@RequestMapping("/test5.action")
	public User test5(){
		User user = new User();
		user.setUsername("dhl");
		user.setEmail("dhl@qq.com");
		Dog dog = new Dog();
		dog.setName("小旺财");
		user.setDog(dog);
		return user;
	}
	
	
}
