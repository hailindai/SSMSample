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
 * ����ֵ���ͺͻ�ȡ����
 */
@Controller
@RequestMapping("/param")
public class Test3Controller {

	/**
	 * ��ȡrequest,response
	 * @return
	 */
	@RequestMapping("/test1.action")
	public String test1(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("attr1", request.getContextPath());
		return "first"; 
	}
	
	/**
	 * ��ȡ�������
	 * ͨ��request,response
	 * @return
	 */
	@RequestMapping("/test2.action")
	public String test2(HttpServletRequest request,HttpServletResponse response){
		request.setAttribute("attr1", request.getParameter("username"));
		return "first"; 
	}
	
	/**
	 * ��ȡ�������
	 * ֱ�ӻ�ȡ
	 * @return
	 */
	@RequestMapping("/test3.action")
	public String test3(Model model,String username){
		model.addAttribute("attr1", username);
		return "first"; 
	}
	
	/**
	 * ��ȡ�������
	 * ֱ�ӻ�ȡ,����
	 * @return
	 */
	@RequestMapping("/test4.action")
	public String test4(Model model,@RequestParam("username")String name){
		model.addAttribute("attr1", name);
		return "first"; 
	}
	
	/**
	 * ��ȡ�������
	 * �Զ���װ��Ϣ��bean
	 * @return
	 */
	@RequestMapping("/test5.action")
	public String test5(Model model,User user){
		model.addAttribute("attr1", user.getUsername() + user.getEmail() + user.getDog().getName());
		return "first";
	}
	
	/**
	 * ��ȡ�������
	 * ����������� String
	 * @return
	 */
	@RequestMapping("/test6.action")
	public String test6(Model model,String like){
		model.addAttribute("attr1", like);
		return "first";
	}
	
	/**
	 * ��ȡ�������
	 * ����������� String[]
	 * @return
	 */
	@RequestMapping("/test7.action")
	public String test7(Model model,String[] like){
		model.addAttribute("attr1", Arrays.asList(like).toString());
		return "first";
	}
	
	/**
	 * ��ȡ�������
	 * ������
	 * 1 �޸ķ�����Ĭ�Ͻ�����������õı���
	 * 2 �ֶ������
	 * 3 request.setCharacterEncoding,ֻ֧��post,ע����Ҫ�Լ���request��ȡ����
	 * 4 ����SpringMVC�ṩ�����������,ֻ֧��post
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
	 * ���ڴ���
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
	 * ���ڴ���
	 * ��SpringMVC�н���ҳ���ύ���������ʱ��Ĭ�ϰ���yyyy/MM/dd�ĸ�ʽ�������ݵ�,��������Data��Ĭ�ϴ�����ƣ�
	 * �����޷��Զ���ȡ��װ���ڵ�Data����ʱ���������������Լ���ָ����ʽ
	 * @param binder
	 */
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder){
		binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd"), true));
	}
	
	
	/**
	 * �ļ��ϴ�
	 * 1 ������ enctype="multipart/form-data"��������name����
	 * 2 �����ļ��ϴ�������bean
	 */
	@RequestMapping("/test10.action")
	public String test10(Model model,MultipartFile file) throws Exception{
		model.addAttribute("attr1", file.getName());
		FileUtils.writeByteArrayToFile(new File("e://" + file.getOriginalFilename()), file.getBytes());
		return "first";
	}
	
	/**
	 * RESTFul��������
	 * @return
	 */
	@RequestMapping("/test11/{username}/{age}.action")
	public String test11(Model model,@PathVariable String username,@PathVariable int age){
		System.out.println("name:" + username);
		System.out.println("age:" + age);
		return "first";
	}
}

