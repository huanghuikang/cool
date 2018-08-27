package cn.itcast.jdbc;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.util.Properties;

import org.junit.Test;

public class Demo {
	private String url = "jdbc:mysql://localhost:3306/people";
	private String user = "root";
	private String pwd = "605296";
	@Test
	public void Test1() throws Exception {
		//Driver driver = new com.mysql.jdbc.Driver();
		Driver driver = new org.gjt.mm.mysql.Driver();
		DriverManager.registerDriver(driver);
		Properties props = new Properties();
		props.setProperty("user", user);
		props.setProperty("pwd", pwd);
		Connection conn = driver.connect(url, props);
		System.out.println(conn);
		
	}
	@Test
	public void Test3() throws Exception {
		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = DriverManager.getConnection(url, user, pwd);
		System.out.println(conn);
	}
	public void main(String[] args) throws Exception {
		Test1();
		Test3();
	}
}
