package cn.itcast.b_statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo1 {
	private Connection conn;
	private Statement st;
	private ResultSet rs;
	private String url = "jdbc:mysql://localhost:3306/people";
	private String user = "root";
	private String pwd = "605296";
	@org.junit.Test
	public void Test() throws Exception {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, pwd);
			st = conn.createStatement();
			String sql = "select * from people.student";
			rs = st.executeQuery(sql);
			while(rs.next()) {
				String id = rs.getString("id");
				String name = rs.getString("name");
				String age = rs.getString("age");
				
				System.out.println(id +":" +name +":" + age +":");
			}
		}
		catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
		finally {
			if(st != null) {
				try {
					st.close();
				}
				catch (Exception e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
			if(conn != null) {
				try {
					conn.close();
				} 
				catch (SQLException e) {
					e.printStackTrace();
					throw new RuntimeException(e);
				}
			}
		}
	}
	

}
