package com.dreamguard.test3;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

/**
 * ����
 */
interface Worker{
	/**
	 * ���˸ɻ�
	 */
	public void work();
	
	/**
	 * ���˳Է�
	 */
	public void eat();
}
/**
 * ľ��
 */
class WoodWorker implements Worker{
	public void work(){
		System.out.println("ľ����ʼ�ɻ�");
	}

	@Override
	public void eat() {
		System.out.println("ľ����ʼ�Է�");
	}
}

/**
 * ��̬����,CGLIBʵ�֣��������ӿ�,������Ҫ�����
 */
public class DynamicProxyByCGLIB {
	public static void main(String[] args) {
		//Ҫ������Ķ���
		final WoodWorker worker = new WoodWorker();
		//��ǿ��
		Enhancer enhancer = new Enhancer();
		//�趨���� -- �˴�Ҫ���뱻�����ߵ��࣬cglib��ͨ�����ɱ������ߵ��������кͱ���������ͬ�ķ����ģ��˷�����������
		enhancer.setSuperclass(worker.getClass());
		//�趨�ص����� -- Ϊ��ǿ���趨�ص�������֮��ͨ����ǿ�����ɵĴ����������κη��������ߵ��˻ص������У�ʵ�ֵ����������������ķ�����Ч��
		enhancer.setCallback(new MethodInterceptor() {
			
			@Override
			public Object intercept(Object proxy, Method method, Object[] args,
					MethodProxy methodProxy) throws Throwable {
				// TODO Auto-generated method stub
				Object result = null;
				if("work".equals(method.getName())){
					System.out.println("����ǰ��Ϊľ��׼����������");
					result = method.invoke(worker, args);
					System.out.println("����������˴�ɨ�ֳ�");
				}else if("eat".equals(method.getName())){
					System.out.println("�緹ǰ��Ϊľ��׼�����緹");
					result = method.invoke(worker, args);
					System.out.println("�緹��Ϊľ�����߷�������");
				}
				return result;
			}
		});
		
		Worker workerProxy = (Worker) enhancer.create();
		workerProxy.work();
		workerProxy.eat();
	}
}
