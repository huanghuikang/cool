package cn.itcast.app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.junit.Test;

import cn.itcast.entity.Admin;
import cn.itcast.utils.JdbcUtil;

public class App {
	//ʹ��DbUtils�������
	@Test
	public void testUpdate() throws Exception {
		String sql="delete from admin where id=0";
		/**
		 * 1������
		 * 2���������Ĺ�����
		 * 3������
		 * 4���ر�
		 * */
		Connection conn=JdbcUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		qr.update(conn, sql);
		conn.close();
	}
	//2��ʹ��DbUtils�����ѯ
	@Test
	public void testQuery() throws Exception {
		String sql="select * from admin";
		Connection conn=JdbcUtil.getConnection();
		QueryRunner qr=new QueryRunner();
		List<Admin> list=qr.query(conn, sql, new BeanListHandler<Admin>(Admin.class));
		System.out.println(list);
		conn.close();
		
	}

}
