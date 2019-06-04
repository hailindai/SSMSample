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

@Component
@Aspect
public class FirstAspect {

	/**
	 * 统计异常信息
	 */
	//@AfterThrowing(value="execution(* com.dreamguard.service.*.*(..))",throwing="e")
	public void afterThrowing(JoinPoint joinPoint,Throwable e){
		Class<? extends Object> clz = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		System.out.println("发现异常信息" + clz.getName() + methodName + e.getMessage());
	}
	/**
	 * 统计方法执行时间
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	//@Around("execution(* com.dreamguard.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable{
		Class<? extends Object> clz = joinPoint.getTarget().getClass();
		String methodName = joinPoint.getSignature().getName();
		long start = System.currentTimeMillis();
		Object object = joinPoint.proceed();
		long end = System.currentTimeMillis();
		System.out.println(clz.getName() + "---" +methodName +"方法执行了：" + (end - start) + "ms");
		return object;
	}
	
}
