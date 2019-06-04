package com.dreamguard.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.anno.PrivEnum;
import com.dreamguard.domain.User;
import com.dreamguard.web.UserController;

/**
 * ͳ���쳣��Ϣ
 * ͳ�Ʒ���ִ��ʱ��
 * Ȩ�޿���
 * ����
 * @author Administrator
 *
 */
public class Test01 {
	//�ֲ߳̾����������߳����δ��ݽ�ɫ
	public static ThreadLocal<PrivEnum> threadLocal = new ThreadLocal<PrivEnum>();
	
	public static void main(String[] args) {

		//��һ���̣߳�ģ��ADMIN
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadLocal.set(PrivEnum.ADMIN);
				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				UserController userController = context.getBean(UserController.class);
				userController.registerUser(new User(1,"���","123","123@qq.com"));
				userController.deleteUser(1);
				userController.updateUser(new User(1,"���","321","123@qq.com"));
				userController.queryUser(1);
				threadLocal.remove();
				
			}
		}).start();
		//�ڶ����̣߳�ģ��USER
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				threadLocal.set(PrivEnum.USER);
//				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//				UserController userController = context.getBean(UserController.class);
//				userController.registerUser(new User(1,"�˽�","123","123@qq.com"));
//				userController.deleteUser(1);
//				userController.updateUser(new User(1,"�˽�","321","123@qq.com"));
//				userController.queryUser(1);
//				threadLocal.remove();
//				
//			}
//		}).start();
	}

}
