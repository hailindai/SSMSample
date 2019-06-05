package com.dreamguard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * �޶�ƥ������
 */
@Controller
@RequestMapping("/test1")	//ָ����·��
public class Test1Controller {
	/*--------------value---------------*/
	@RequestMapping("/test1.action")//ָ��ӳ�䵽��Щ·����������ͨ�����placeholder
	public void test1(){
		System.out.println("ָ��ӳ�䵽��Щ·��");
	}
	/*--------------value---------------*/
	
	
	/*--------------method---------------*/
	@RequestMapping(value="/test2.action",method={RequestMethod.GET}) //�޶�����ʽ
	public void test2(){
		System.out.println("�޶�����ʽ");
	}
	/*--------------method---------------*/
	
	
	/*--------------params---------------*/
	@RequestMapping(value="/test3.action",params={"username"}) //�޶��������������
	public void test3(){
		System.out.println("�޶��������������");
	}
	
	@RequestMapping(value="/test4.action",params={"username=dhl"}) //�޶��������������
	public void test4(){
		System.out.println("�޶��������������,��ֵΪdhl");
	}
	
	@RequestMapping(value="/test5.action",params={"!username"}) //�޶�������û��ָ���������
	public void test5(){
		System.out.println("�޶�����û��ָ���������");
	}
	/*--------------params---------------*/
	
	
	/*--------------headers---------------*/
	//����param
	@RequestMapping(value="/test6.action",headers={"host"}) //�޶�������ָ������ͷ
	public void test6(){
		System.out.println("�޶�������ָ������ͷ");
	}
	/*--------------headers---------------*/
}
