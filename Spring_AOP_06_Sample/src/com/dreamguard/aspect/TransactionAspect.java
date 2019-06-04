package com.dreamguard.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.dreamguard.anno.Trans;
import com.dreamguard.util.TransactionManager;

@Component
@Aspect
public class TransactionAspect {

	@Around("execution(* com.dreamguard.service.*.*(..)) && @annotation(ta)")//要求必须有注解，且为Trans,才切出
	public Object around(ProceedingJoinPoint joinPoint,Trans ta) throws Throwable {
		Object ret = null;
		try {
			TransactionManager.startTransaction();
			ret = joinPoint.proceed();
			TransactionManager.commit();
			return ret;
		} catch (Exception e) {
			TransactionManager.rollback();
			throw e;
		} finally{
//			TransactionManager.close();
		}

	}
}
