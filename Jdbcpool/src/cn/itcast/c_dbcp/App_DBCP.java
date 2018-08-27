package cn.itcast.c_dbcp;

import java.io.InputStream;
import java.sql.Connection;
import java.util.Properties;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.junit.Test;

public class App_DBCP {
	//1��Ӳ���뷽ʽʵ�����ӳ�
	@Test
	public void testDbcp() throws Exception {
		//DBCP���ӳغ�����
		BasicDataSource dataSource=new BasicDataSource();
		/**���ӳز������ã���ʼ���������������������
		 * �����ַ������������û�������
		 * ���ݿ������ַ���
		 * ���ݿ�����
		 * ���ݿ������û�������
		 * ��ʼ�����ӡ�������ӡ�������ʱ��
		 * ��ȡ����
		 * �ر�
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
	//2.���Ƽ������÷�ʽʵ�����ӳأ�����ά��
	
	@Test
	/**
	 * ����prop�����ļ�
	 * ��ȡ�ļ���
	 * �������������ļ�
	 * ����prop���ã�ֱ�Ӵ�������Դ����
	 * ��ȡ����
	 * �ر�
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
