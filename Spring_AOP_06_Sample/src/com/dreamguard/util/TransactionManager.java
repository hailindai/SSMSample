package com.dreamguard.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
	
	public static void startTransaction(){
		System.out.println("��������");
	}
	
	public static void commit(){
		System.out.println("�ύ����");
	}
	
	public static void rollback(){
		System.out.println("�ع�����");
	}
	
	public static void close(){
		System.out.println("�ر�����");
	}
	
}
