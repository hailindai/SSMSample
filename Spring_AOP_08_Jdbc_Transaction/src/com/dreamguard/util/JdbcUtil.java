package com.dreamguard.util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.dreamguard.web.UserController;
import com.mchange.v2.c3p0.ComboPooledDataSource;

/**
 * jdbc工具
 * @email 605345320@qq.com
 * @author hailin.dai
 */
@SuppressWarnings("static-access")
public class JdbcUtil {
	private static int DATASOURCE_TYPE = 0;
	private static Connection connection = null;
	private static PreparedStatement statement = null;
	private static ResultSet resultSet = null;

	private static DataSource dataSource = null;
	static {
		if (DATASOURCE_TYPE == 0) {
//			dataSource = new ComboPooledDataSource();
			//通过Spring获取实例
			ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
			dataSource = (DataSource) context.getBean("dataSource");
		} else if (DATASOURCE_TYPE == 1) {
//			Properties prop = new Properties();
//			try {
//				prop.load(new FileInputStream(JdbcUtil.class.getClassLoader()
//						.getResource("dbcp.properties").getPath()));
//				dataSource = new BasicDataSourceFactory()
//						.createDataSource(prop);
//			} catch (Exception e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		} else if (DATASOURCE_TYPE == 2){
//			dataSource = new SimpleDataSource();
		}
	}

	/**
	 * 获取连接
	 * 
	 * @return
	 */
	private static Connection getConnection() {
		try {
			connection = dataSource.getConnection();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}

	/**
	 * 获取传输器
	 * 
	 * @param sql
	 *            sql语句
	 * @param params
	 *            参数
	 * @return
	 */
	private static PreparedStatement getPreparedStatement(String sql,
			Object... params) {
		connection = getConnection();
		try {
			statement = connection.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				statement.setObject(i + 1, params[i]);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return statement;
	}

	/**
	 * 更新
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int update(String sql, Object... params) {
		int count = 0;
		try {
			count = getPreparedStatement(sql, params).executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("受到影响的行数：" + count);
		close(resultSet, statement, connection);
		return count;
	}

	/**
	 * 插入
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int insert(String sql, Object... params) {
		return update(sql, params);
	}

	/**
	 * 查询
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static List<List<Object>> select(String sql, Object... params) {
		List<List<Object>> list = new ArrayList<List<Object>>();
		statement = getPreparedStatement(sql, params);
		try {
			resultSet = statement.executeQuery();
			while (resultSet.next()) {
				List<Object> item = new ArrayList<Object>();
				for (int i = 0; i < resultSet.getMetaData().getColumnCount(); i++) {
					item.add(resultSet.getObject(i + 1));
				}
				list.add(item);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		close(resultSet, statement, connection);
		return list;
	}

	public static void print(List<List<Object>> value) {
		for (List<Object> row : value) {
			for (Object item : row) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 删除
	 * 
	 * @param sql
	 * @param params
	 * @return
	 */
	public static int delete(String sql, Object... params) {
		return update(sql, params);
	}

	/**
	 * 断开连接
	 * 
	 * @param resultSet
	 * @param statement
	 * @param connection
	 */
	private static void close(ResultSet resultSet, Statement statement,
			Connection connection) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				resultSet = null;
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				statement = null;
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				connection = null;
			}
		}
	}
}
