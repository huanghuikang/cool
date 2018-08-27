package cn.itcast.c_dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class App_DBCP {
	//1、硬编码方式实现连接池
	@Test
	public void testDbcp() throws Exception {
		//DBCP连接池核心类
		BasicDataSource dataSource=new BasicDataSource();
		/**连接池参数配置，初始化连接数、最大连接数、
		 * 连接字符串、驱动、用户、密码
		 * 数据库连接字符串
		 * 数据库驱动
		 * 数据库连接用户、密码
		 * 初始化连接、最大连接、最大空闲时间
		 * 获取连接
		 * 关闭
		 * */
		dataSource.setUrl("jdbc:mysql:///jdbc_demo");
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUsername("root");
		dataSource.setPassword("605296");
		dataSource.setInitialSize(3);
		dataSource.setMaxActive(6);
		dataSource.setMaxIdle(3000);
		Connection conn=dataSource.getConnection();
		conn.prepareStatement("delete from admin where id=3").executeUpdate();
		conn.close();
	}
	//2.【推荐】配置方式实现连接池，便于维护
	
	@Test
	/**
	 * 加载prop配置文件
	 * 获取文件流
	 * 加载属性配置文件
	 * 根据prop配置，直接创建数据源对象
	 * 获取连接
	 * 关闭
	 * 
	 **/
	public void testProp() throws Exception {
		Properties prop=new Properties();
		InputStream inStream=App_DBCP.class.getResourceAsStream("db.properties");
		prop.load(inStream);
		DataSource dataSouce=BasicDataSourceFactory.createDataSource(prop);
		Connection conn=dataSouce.getConnection();
		conn.prepareStatement("delete from admin where id=4").executeUpdate();
		conn.close();
	}
}
