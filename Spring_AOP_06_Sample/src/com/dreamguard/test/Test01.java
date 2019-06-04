package com.dreamguard.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.anno.PrivEnum;
import com.dreamguard.domain.User;
import com.dreamguard.web.UserController;

/**
 * 统计异常信息
 * 统计方法执行时间
 * 权限控制
 * 事务
 * @author Administrator
 *
 */
public class Test01 {
	//线程局部变量，向线程下游传递角色
	public static ThreadLocal<PrivEnum> threadLocal = new ThreadLocal<PrivEnum>();
	
	public static void main(String[] args) {

		//第一个线程，模仿ADMIN
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				threadLocal.set(PrivEnum.ADMIN);
				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
				UserController userController = context.getBean(UserController.class);
				userController.registerUser(new User(1,"悟空","123","123@qq.com"));
				userController.deleteUser(1);
				userController.updateUser(new User(1,"悟空","321","123@qq.com"));
				userController.queryUser(1);
				threadLocal.remove();
				
			}
		}).start();
		//第二个线程，模仿USER
//		new Thread(new Runnable() {
//			
//			@Override
//			public void run() {
//				threadLocal.set(PrivEnum.USER);
//				ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//				UserController userController = context.getBean(UserController.class);
//				userController.registerUser(new User(1,"八戒","123","123@qq.com"));
//				userController.deleteUser(1);
//				userController.updateUser(new User(1,"八戒","321","123@qq.com"));
//				userController.queryUser(1);
//				threadLocal.remove();
//				
//			}
//		}).start();
	}

}
