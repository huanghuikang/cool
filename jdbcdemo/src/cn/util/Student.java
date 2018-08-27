package cn.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import cn.dao.jdbc;

public class Student {

	private static Connection conn;
	private static Statement st;
	private static ResultSet rs;
	public static void Selecttest() throws Exception {
		conn = jdbc.getConnection();
		st = conn.createStatement();
		String sql = "SELECT * FROM people.student";
		rs = st.executeQuery(sql);
		while(rs.next()) {
			String id = rs.getString("id");
			String name = rs.getString("name");
			String age = rs.getString("age");
			
			System.out.println(id +":" +name +":" + age +":");
		}
		System.out.println(sql);
		jdbc.closeAll(conn, st, rs);
		
	}
	public static void main(String[] args) throws Exception {
		Selecttest();
	}
}
