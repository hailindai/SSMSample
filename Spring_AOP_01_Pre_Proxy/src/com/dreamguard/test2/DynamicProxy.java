package com.dreamguard.test2;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

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
 * ��̬����
 * �ŵ㣺����Ҫ��̬����һ������������Ҫʵ��һ�飬��ֻ��Ҫ�ڻص������н��д���Ϳ����ˣ��ظ�����ֻ���дһ�Ρ�
 * ȱ�㣺�޽ӿڲ���ʵ��
 */
public class DynamicProxy {
	public static void main(String[] args) {
		//Ҫ������Ķ���
		final WoodWorker worker = new WoodWorker();
		//������
		/**
		 * classLoader:�������ɴ�����������������ͨ�����Դ��뱻����������������
		 * interfaces: Ҫ�����ɵĴ�����ʵ�ֵĽӿ��ǣ�ͨ������ʵ�ֺͱ���������ͬ�Ľӿڣ���֤���кͱ���������ͬ�ķ���
		 * invocationHandler: �����趨�ص������Ļص��ӿڣ�ʹ������Ҫдһ����ʵ�ִ˽ӿڣ��Ӷ�ʵ�����е�invoke�����������б�д���봦������ߵ��÷���ʱ�Ļص����̣�ͨ����������������������ϵķ����������ڷ���֮ǰ��֮�������������
		 */
		Worker workerProxy = (Worker)Proxy.newProxyInstance(WoodWorker.class.getClassLoader(), WoodWorker.class.getInterfaces(), new InvocationHandler() {
			/**
			 * proxy: ������
			 * method:��ǰ���õķ�������
			 * args:��ǽ���õķ����Ĳ�������
			 */
			@Override
			public Object invoke(Object proxy, Method method, Object[] args)
					throws Throwable {
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
		
		workerProxy.work();
		workerProxy.eat();
	}
}
