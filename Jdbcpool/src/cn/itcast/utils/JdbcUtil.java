package cn.itcast.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 1、返回连接
 * 2、关闭
 * */

public class JdbcUtil {
	//private static String url="jdbc:mysql://localhost:3306/jdbc_demo";
	private static String url="jdbc:mysql:///jdbc_demo";
	private static String user="root";
	private static String password="605296";
	//返回连接对象
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(url, user, password);
		}
		catch (Exception e) {
			throw new RuntimeException();
		}
	}
	//关闭
	public static void closeAll(Connection conn,Statement st,ResultSet rs) {
		try {
			if(rs!=null) {
				rs.close();
				rs=null;
			}
			if(st!=null) {
				st.close();
				st=null;
			}
			if(conn!=null) {
				conn.close();
				conn=null;
			}
		}
		catch (SQLException e) {
			throw new RuntimeException();
		}
	}
}
