package com.dreamguard.test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * 工人
 */
interface Worker{
	/**
	 * 工人干活
	 */
	public void work();
	
	/**
	 * 工人吃饭
	 */
	public void eat();
}
/**
 * 木工
 */
class WoodWorker implements Worker{
	public void work(){
		System.out.println("木工开始干活");
	}

	@Override
	public void eat() {
		System.out.println("木工开始吃饭");
	}
}

/**
 * 动态代理,CGLIB实现，不依赖接口,但是需要导入包
 */
public class DynamicProxyByCGLIB {
	public static void main(String[] args) {
		//要被代理的对象
		final WoodWorker worker = new WoodWorker();
		//增强器
		Enhancer enhancer = new Enhancer();
		//设定父类 -- 此处要传入被代理者的类，cglib是通过集成被代理者的类来持有和被代理者相同的方法的，此方法必须设置
		enhancer.setSuperclass(worker.getClass());
		//设定回调函数 -- 为增强器设定回调函数，之后通过增强器生成的代理对象调用任何方法都会走到此回调函数中，实现调用真正被代理对象的方法的效果
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				// TODO Auto-generated method stub
				Object result = null;
				if("work".equals(method.getName())){
					System.out.println("工作前，为木工准备工作材料");
					result = method.invoke(worker, args);
					System.out.println("工作完后，找人打扫现场");
				}else if("eat".equals(method.getName())){
					System.out.println("午饭前，为木工准备好午饭");
					result = method.invoke(worker, args);
					System.out.println("午饭后，为木工带走饭后垃圾");
				}
				return result;
			}
		});
		
		Worker workerProxy = (Worker) enhancer.create();
		workerProxy.work();
		workerProxy.eat();
	}
}
