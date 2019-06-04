package com.dreamguard.aspect;

import java.lang.reflect.Method;
import java.util.Arrays;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import com.dreamguard.anno.Priv;
import com.dreamguard.test.Test01;

@Component
@Aspect
public class PrivAspect {

	/**
	 * 权限访问控制
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.dreamguard.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		// 获取注解
		// PrivEnum privEnum = pa.value();
		// System.out.println(privEnum);
		// 1.获取当前方法
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Class<? extends Object> clz = joinPoint.getTarget().getClass();
		Method instanceMethod = clz.getMethod(method.getName(),
				method.getParameterTypes());

		if (instanceMethod.isAnnotationPresent(Priv.class)) {
			// 2.需要权限
			// 获取需要的权限
			Priv annotation = instanceMethod.getAnnotation(Priv.class);
			// 获取自己的权限
			// 权限匹配
			if (Arrays.asList(annotation.value()).contains(Test01.threadLocal.get())) {
				System.out.print("用户级别:" + Test01.threadLocal.get());
				System.out.print("放行:");
				Object object = joinPoint.proceed();
				return object;
			}else {
				throw new RuntimeException("权限不够");
			}
		} else {
			// 不需要权限，放行
			Object object = joinPoint.proceed();
			return object;
		}
	}

}
