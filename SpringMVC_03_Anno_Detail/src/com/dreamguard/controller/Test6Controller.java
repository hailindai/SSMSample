package com.dreamguard.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 * json
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/json")
public class Test6Controller {
	
	/**
	 * 返回一段数据
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/test1.action")
	public void test1(HttpServletResponse response) throws IOException{
		response.getWriter().write("hello world");
	}
	/**
	 * 返回一段数据
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/test2.action")
	public void test2(PrintWriter writer) throws IOException{
		writer.write("hello world2");
	}
	
	/**
	 * 返回一段json
	 * @param response
	 * @return
	 * @throws IOException
	 */
	@RequestMapping("/test3.action")
	@ResponseBody
	public User test3(HttpServletResponse response) throws IOException{
		User user = new User();
		user.setUsername("dhl");
		user.setEmail("dhl@qq.com");
		Dog dog = new Dog();
		dog.setName("小旺财");
		user.setDog(dog);
		return user;
	}
	
	
	/**
	 * 手动返回一段json,不建议
	 * @return
	 * @throws IOException 
	 */
	@RequestMapping("/test4.action")
	public void test4(HttpServletResponse response) throws IOException{
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().write("{'username':'dhl','email':'dhl@qq.com','dog':{'name':'小旺财'}}");
	}
	
}
