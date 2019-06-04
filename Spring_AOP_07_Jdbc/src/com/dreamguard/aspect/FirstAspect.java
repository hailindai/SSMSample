package com.dreamguard.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

//@Component
//@Aspect
public class FirstAspect {
	/**
	 * ����һ�����ʽ��������ʹ��
	 */
	@Pointcut("execution(* com.dreamguard.service.*.queryUser(..))")
	public void pointCut(){
		
	}
	
	/**
	 * 
	 */
	@Before("pointCut()")
	public void before(JoinPoint joinPoint){
		joinPoint.getTarget();//��ȡĿ�����
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();//�ܹ���ȡĿ�귽���������
		signature.getMethod();
		signature.getName();
		signature.getParameterTypes();
		signature.getReturnType();
		System.out.println("FirstAspect�е�beforeִ����");
	}
	/**
	 * 
	 */
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint jointPoint) throws Throwable{
		System.out.println("FirstAspect�е�around ��ʼ");
		Object object = jointPoint.proceed();
		System.out.println("FirstAspect�е�around ����");
		return object;
	}
	
	/**
	 * 
	 */
	@AfterReturning(value="pointCut()",returning="returnObject")
	public void afterReturning(JoinPoint joinPoint,Object returnObject){
		System.out.println("FirstAspect�е�afterReturningִ����" + returnObject);
	}
	
	/**
	 * 
	 */
	@AfterThrowing(value="pointCut()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("FirstAspect�е�afterThrowingִ����" + e);
	}
	
	/**
	 * 
	 */
	@After("pointCut()")
	public void after(JoinPoint joinPoint){
		System.out.println("FirstAspect�е�afterִ����");
	}
}
