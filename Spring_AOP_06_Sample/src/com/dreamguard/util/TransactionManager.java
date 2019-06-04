package com.dreamguard.util;

import java.sql.Connection;
import java.sql.SQLException;

public class TransactionManager {
	
	public static void startTransaction(){
		System.out.println("开启事务");
	}
	
	public static void commit(){
		System.out.println("提交事务");
	}
	
	public static void rollback(){
		System.out.println("回滚事务");
	}
	
	public static void close(){
		System.out.println("关闭连接");
	}
	
}
