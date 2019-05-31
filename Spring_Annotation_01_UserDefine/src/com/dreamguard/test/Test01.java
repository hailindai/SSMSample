package com.dreamguard.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.junit.Test;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface level{		//@interface ����һ��ע��
	String value() default "����";
}

@level
class Police{
	public static void fine(){
		System.out.println("���ѳ��٣��뽻200Ԫ");
	}
}

public class Test01 {
	@Test
	public void test01() throws Exception {
		Police.fine();
		if(Police.class.isAnnotationPresent(level.class)){
			System.out.println("���ã�����200Ԫ");
		}else{
			System.out.println("������ƭ��");
		}
	}
}
