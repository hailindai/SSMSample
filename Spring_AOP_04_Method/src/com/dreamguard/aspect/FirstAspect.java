package com.dreamguard.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
public class FirstAspect {
	/**
	 * ��Ŀ�귽��ִ��֮ǰִ��ִ�е�֪ͨ
	 * ǰ��֪ͨ����������û�в�����Ҳ���Զ������һ��JoinPoint��Spring���Զ����ö����룬����ǰ�����ӵ㣬ͨ���ö�����Ի�ȡĿ����� �� Ŀ�귽����ص���Ϣ��
	 * ע�⣬�������JoinPoint�����뱣֤��Ϊ�����ĵ�һ�����������򱨴�
	 * @param joinPoint
	 */
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
	 * ��Ŀ�귽��ִ��֮ǰ��֮�󶼿���ִ�ж�������֪ͨ��
	 * �ڻ���֪ͨ�б�����ʽ�ĵ���Ŀ�귽��������Ŀ�귽������ִ�С�
	 * �����ʽ����ʱͨ��ProceedingJoinPoint��ʵ�ֵģ������ڻ���֪ͨ�н���һ�������͵��βΣ�spring�������Զ����ö����룬����������봦�ڻ���֪ͨ�ĵ�һ���β�λ�á�
	 * ����֪ͨ��Ҫ���ط���ֵ���������������߽��ò�������ֵ��ֻ�ܵõ�һ��null��
	 * 
	 * ����֪ͨ�У�����Ŀ�귽���Ƿ�ִ�С�Ŀ�귽��ִ��֮ǰ��֮��ִ�ж�����롢�п����Ƿ񷵻�ֵ�������ı䷵��ֵ������
	 * ����������������ҪС�Ĳ�Ҫ�ƻ�������ֲ�ġ����ھ� ����ϡ���Ŀ�ꡣ
	 * @param jointPoint
	 * @return
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint jointPoint) throws Throwable{
		System.out.println("FirstAspect�е�around ��ʼ");
		Object object = jointPoint.proceed();
		System.out.println("FirstAspect�е�around ����");
		return object;
	}
	
	/**
	 * ��Ŀ�귽��ִ��֮��ִ��ִ�е�֪ͨ
	 * ����֪ͨ�У�������ͨ�����û�ȡ����ֵ
	 * @param joinPoint
	 */
	public void afterReturning(JoinPoint joinPoint,Object returnObject){
		System.out.println("FirstAspect�е�afterReturningִ����" + returnObject);
	}
	
	/**
	 * ��Ŀ�귽���׳��쳣ʱִ�е�֪ͨ
	 * ���������ò��������쳣֪ͨ���Խ��յ�Ŀ�귽���׳����쳣����
	 * @param joinPoint
	 * @param e
	 */
	public void afterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("FirstAspect�е�afterThrowingִ����" + e);
	}
	
	/**
	 * ����֪ͨ
	 * ������ζ�����Ŀ�귽�����ù���ִ�У���ʹĿ�귽��û��������ִ�����
	 * @param joinPoint
	 */
	public void after(JoinPoint joinPoint){
		System.out.println("FirstAspect�е�afterִ����");
	}
}
