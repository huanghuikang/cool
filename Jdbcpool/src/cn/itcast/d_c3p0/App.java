package cn.itcast.d_c3p0;


import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class App {
	//1��Ӳ���뷽ʽ��ʹ��C3P0���ӳع�������
	@Test
	public void testCode() throws Exception {
		//�������ӳغ��Ĺ�����
		ComboPooledDataSource dataSource=new ComboPooledDataSource();
		//�������Ӳ�����url���������û����롢��ʼ�����������������
		dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/jdbc_demo");
		dataSource.setDriverClass("com.mysql.jdbc.Driver");
		dataSource.setUser("root");
		dataSource.setPassword("65296");
		dataSource.setInitialPoolSize(3);
		dataSource.setMaxPoolSize(6);
		dataSource.setMaxIdleTime(1000);
		//�����ӳض����У���ȡ���Ӷ���
		Connection conn=dataSource.getConnection();
		//ִ�и���
		conn.prepareStatement("delete from admin where id=7").executeUpdate();
		conn.close();
	}
	//2��XML���÷�ʽ��ʹ��C3P0���ӳع�������
	@Test
	public void testXML() throws Exception {
		//����c3p0���ӳغ��Ĺ�����
		//�Զ�����src��c3p0�������ļ���c3p0=config.xml��
		ComboPooledDataSource dataSource=new ComboPooledDataSource();//ʹ��Ĭ�ϵ�����
		PreparedStatement ps=null;
		Connection conn=dataSource.getConnection();
		for(int i=1;i<11;i++) {
			String sql="insert into employee(empName,dept_id) values(?,?)";
			ps=conn.prepareStatement(sql);
			ps.setString(1, "Rose"+i);
			ps.setInt(2, 1);
			ps.executeUpdate();
		}
		ps.close();
		conn.close();
	}
}
