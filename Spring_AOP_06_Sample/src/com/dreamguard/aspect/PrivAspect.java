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
	 * Ȩ�޷��ʿ���
	 * @param joinPoint
	 * @return
	 * @throws Throwable
	 */
	@Around("execution(* com.dreamguard.service.*.*(..))")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		// ��ȡע��
		// PrivEnum privEnum = pa.value();
		// System.out.println(privEnum);
		// 1.��ȡ��ǰ����
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();
		Class<? extends Object> clz = joinPoint.getTarget().getClass();
		Method instanceMethod = clz.getMethod(method.getName(),
				method.getParameterTypes());

		if (instanceMethod.isAnnotationPresent(Priv.class)) {
			// 2.��ҪȨ��
			// ��ȡ��Ҫ��Ȩ��
			Priv annotation = instanceMethod.getAnnotation(Priv.class);
			// ��ȡ�Լ���Ȩ��
			// Ȩ��ƥ��
			if (Arrays.asList(annotation.value()).contains(Test01.threadLocal.get())) {
				System.out.print("�û�����:" + Test01.threadLocal.get());
				System.out.print("����:");
				Object object = joinPoint.proceed();
				return object;
			}else {
				throw new RuntimeException("Ȩ�޲���");
			}
		} else {
			// ����ҪȨ�ޣ�����
			Object object = joinPoint.proceed();
			return object;
		}
	}

}
