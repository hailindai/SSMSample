package com.dreamguard.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
public class FirstAspect {
	/**
	 * 在目标方法执行之前执行执行的通知
	 * 前置通知方法，可以没有参数，也可以额外接收一个JoinPoint，Spring会自动将该对象传入，代表当前的连接点，通过该对象可以获取目标对象 和 目标方法相关的信息。
	 * 注意，如果接收JoinPoint，必须保证其为方法的第一个参数，否则报错。
	 * @param joinPoint
	 */
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
	 * 在目标方法执行之前和之后都可以执行额外代码的通知。
	 * 在环绕通知中必须显式的调用目标方法，否则目标方法不会执行。
	 * 这个显式调用时通过ProceedingJoinPoint来实现的，可以在环绕通知中接收一个此类型的形参，spring容器会自动将该对象传入，这个参数必须处在环绕通知的第一个形参位置。
	 * 环绕通知需要返回返回值，否则真正调用者将拿不到返回值，只能得到一个null。
	 * 
	 * 环绕通知有：控制目标方法是否执行、目标方法执行之前或之后执行额外代码、有控制是否返回值、甚至改变返回值的能力
	 * 慎用这样的能力，要小心不要破坏了软件分层的“高内聚 低耦合”的目标。
	 * @param jointPoint
	 * @return
	 * @throws Throwable
	 */
	public Object around(ProceedingJoinPoint jointPoint) throws Throwable{
		System.out.println("FirstAspect中的around 开始");
		Object object = jointPoint.proceed();
		System.out.println("FirstAspect中的around 结束");
		return object;
	}
	
	/**
	 * 在目标方法执行之后执行执行的通知
	 * 后置通知中，还可以通过配置获取返回值
	 * @param joinPoint
	 */
	public void afterReturning(JoinPoint joinPoint,Object returnObject){
		System.out.println("FirstAspect中的afterReturning执行了" + returnObject);
	}
	
	/**
	 * 在目标方法抛出异常时执行的通知
	 * 还可以配置参数，让异常通知可以接收到目标方法抛出的异常对象
	 * @param joinPoint
	 * @param e
	 */
	public void afterThrowing(JoinPoint joinPoint,Throwable e){
		System.out.println("FirstAspect中的afterThrowing执行了" + e);
	}
	
	/**
	 * 最终通知
	 * 无论如何都会在目标方法调用过后执行，即使目标方法没有正常的执行完成
	 * @param joinPoint
	 */
	public void after(JoinPoint joinPoint){
		System.out.println("FirstAspect中的after执行了");
	}
}
