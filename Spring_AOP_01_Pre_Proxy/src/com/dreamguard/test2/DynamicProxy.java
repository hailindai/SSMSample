package com.dreamguard.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
 * 动态代理
 * 优点：不需要像静态代理一样被代理方法都要实现一遍，而只需要在回调函数中进行处理就可以了，重复代码只需编写一次。
 * 缺点：无接口不能实现
 */
public class DynamicProxy {
	public static void main(String[] args) {
		//要被代理的对象
		final WoodWorker worker = new WoodWorker();
		//代理者
		/**
		 * classLoader:用来生成代理者类的类加载器，通常可以传入被代理者类的类加载器
		 * interfaces: 要求生成的代理者实现的接口们，通常就是实现和被代理者相同的接口，保证具有和被代理者相同的方法
		 * invocationHandler: 用来设定回调函数的回调接口，使用者需要写一个类实现此接口，从而实现其中的invoke方法，在其中编写代码处理代理者调用方法时的回调过程，通常在这里调用真正对象身上的方法，并且在方法之前或之后做额外操作。
		 */
		Worker workerProxy = (Worker)Proxy.newProxyInstance(WoodWorker.class.getClassLoader(), WoodWorker.class.getInterfaces(), new InvocationHandler() {
			/**
			 * proxy: 代理者
			 * method:当前调用的方法对象
			 * args:挡墙调用的方法的参数数组
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
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
		
		workerProxy.work();
		workerProxy.eat();
	}
}
