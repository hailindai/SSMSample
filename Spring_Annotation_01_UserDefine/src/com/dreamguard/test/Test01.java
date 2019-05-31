package com.dreamguard.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface level{		//@interface 声明一个注解
	String value() default "交警";
}

@level
class Police{
	public static void fine(){
		System.out.println("您已超速，请交200元");
	}
}

public class Test01 {
	@Test
	public void test01() throws Exception {
		Police.fine();
		if(Police.class.isAnnotationPresent(level.class)){
			System.out.println("您好，这是200元");
		}else{
			System.out.println("不交，骗人");
		}
	}
}
