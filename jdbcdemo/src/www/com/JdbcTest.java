package www.com;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcTest {

	
	public static void main(String[] args) throws ClassNotFoundException, SQLException  {
		//通过查询表中的所有数据进行jdbc的讲解
		//1.加载jdbc驱动
		
			Class.forName("com.mysql.jdbc.Driver");
		
		//2.定义连接Url
		String Url = "jdbc:mysql://localhost:3306/user";
		//获取数据库连接
		Connection conn = DriverManager.getConnection(Url, "root", "605296");
		System.out.println(conn);
		
	}

}
