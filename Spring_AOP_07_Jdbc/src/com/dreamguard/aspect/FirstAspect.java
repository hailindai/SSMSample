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
	 * 定义一个表达式，给后面使用
	 */
	@Pointcut("execution(* com.dreamguard.service.*.queryUser(..))")
	public void pointCut(){
		
	}
	
	/**
	 * 
	 */
	@Before("pointCut()")
	public void before(JoinPoint joinPoint){
		joinPoint.getTarget();//获取目标对象
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();//能够获取目标方法相关内容
		signature.getMethod();
		signature.getName();
		signature.getParameterTypes();
		signature.getReturnType();
		System.out.println("FirstAspect中的before执行了");
	}
	/**
	 * 
	 */
	@Around("pointCut()")
	public Object around(ProceedingJoinPoint jointPoint) throws Throwable{
		System.out.println("FirstAspect中的around 开始");
		Object object = jointPoint.proceed();
		System.out.println("FirstAspect中的around 结束");
		return object;
	}
	
	/**
	 * 
	 */
	@AfterReturning(value="pointCut()",returning="returnObject")
	public void afterReturning(JoinPoint joinPoint,Object returnObject){
		System.out.println("FirstAspect中的afterReturning执行了" + returnObject);
	}
	
	/**
	 * 
	 */
	@AfterThrowing(value="pointCut()",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("FirstAspect中的afterThrowing执行了" + e);
	}
	
	/**
	 * 
	 */
	@After("pointCut()")
	public void after(JoinPoint joinPoint){
		System.out.println("FirstAspect中的after执行了");
	}
}
