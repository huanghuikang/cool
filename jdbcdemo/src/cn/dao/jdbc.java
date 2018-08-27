package cn.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class jdbc {
	private static String url = "jdbc:mysql://localhost:3306/people";
	private static String user="root";
	private static String pwd = "605296";
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			System.out.println("Çý¶¯³ÌÐò×¢²á³ö´í");
		}
	}
	
	
	
	public static Connection getConnection(){
		try {
			Connection conn = DriverManager.getConnection(url, user, pwd);
			return conn;
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	public static void closeAll(Connection conn,Statement st,ResultSet rs) {
		try {
			if(rs != null) {
				rs.close();
				rs = null;
			}
			if(st != null) {
				st.close();
				st = null;
			}
			if(conn != null) {
				conn.close();
				conn = null;
			}
		}
		catch (Exception e) {
			throw new RuntimeException(e) ;
		}
	}
	
}
