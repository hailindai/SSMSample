package com.dreamguard.controller;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * 返回值类型和获取参数
 */
@Controller
@RequestMapping("/param")
public class Test3Controller {

	/**
	 * 获取request,response
	 * @return
	 */
	@RequestMapping("/test1.action")
	public String test1(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("attr1", request.getContextPath());
		return "first"; 
	}
	
	/**
	 * 获取请求参数
	 * 通过request,response
	 * @return
	 */
	@RequestMapping("/test2.action")
	public String test2(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("attr1", request.getParameter("username"));
		return "first"; 
	}
	
	/**
	 * 获取请求参数
	 * 直接获取
	 * @return
	 */
	@RequestMapping("/test3.action")
	public String test3(Model model,String username){
		model.addAttribute("attr1", username);
		return "first"; 
	}
	
	/**
	 * 获取请求参数
	 * 直接获取,别名
	 * @return
	 */
	@RequestMapping("/test4.action")
	public String test4(Model model,@RequestParam("username")String name){
		model.addAttribute("attr1", name);
		return "first"; 
	}
	
	/**
	 * 获取请求参数
	 * 自动封装信息到bean
	 * @return
	 */
	@RequestMapping("/test5.action")
	public String test5(Model model,User user){
		model.addAttribute("attr1", user.getUsername() + user.getEmail() + user.getDog().getName());
		return "first";
	}
	
	/**
	 * 获取请求参数
	 * 多个重名参数 String
	 * @return
	 */
	@RequestMapping("/test6.action")
	public String test6(Model model,String like){
		model.addAttribute("attr1", like);
		return "first";
	}
	
	/**
	 * 获取请求参数
	 * 多个重名参数 String[]
	 * @return
	 */
	@RequestMapping("/test7.action")
	public String test7(Model model,String[] like){
		model.addAttribute("attr1", Arrays.asList(like).toString());
		return "first";
	}
	
	/**
	 * 获取请求参数
	 * 乱码解决
	 * 1 修改服务器默认解析请求参数用的编码
	 * 2 手动编解码
	 * 3 request.setCharacterEncoding,只支持post,注意需要自己用request获取参数
	 * 4 配置SpringMVC提供的乱码过滤器,只支持post
	 * @return
	 * @throws Exception 
	 */
	@RequestMapping("/test8.action")
	public String test8(Model model,String like) throws Exception{
//		request.setCharacterEncoding("utf-8");
//		String value = new String(like.getBytes("iso8859-1"),"utf-8");
//		System.out.println(value);
		model.addAttribute("attr1", like);
		System.out.println(like);
		return "first";
	}
	
	/**
	 * 日期处理
	 * @param model
	 * @param date
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/test9.action")
	public String test9(Model model,Date date) throws Exception{
		model.addAttribute("attr1", date.toString());
		System.out.println(date);
		return "first";
	}
	
	/**
	 * 日期处理
	 * 在SpringMVC中解析页面提交的请求参数时，默认按照yyyy/MM/dd的格式解析数据的,并不符合Data类默认处理机制，
	 * 所以无法自动获取封装日期到Data。此时可以配置适配器自己来指定格式
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
	/**
	 * 文件上传
	 * 1 表单配置 enctype="multipart/form-data"，必须有name属性
	 * 2 配置文件上传处理器bean
	 */
	@RequestMapping("/test10.action")
	public String test10(Model model,MultipartFile file) throws Exception{
		model.addAttribute("attr1", file.getName());
		FileUtils.writeByteArrayToFile(new File("e://" + file.getOriginalFilename()), file.getBytes());
		return "first";
	}
	
	/**
	 * RESTFul风格的请求
	 * @return
	 */
	@RequestMapping("/test11/{username}/{age}.action")
	public String test11(Model model,@PathVariable String username,@PathVariable int age){
		System.out.println("name:" + username);
		System.out.println("age:" + age);
		return "first";
	}
}

