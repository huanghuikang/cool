package cn.itcast.dao.impl;

import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import cn.itcast.dao.IEmployeeDao;
import cn.itcast.entity.Employee;
import cn.itcast.utils.JdbcUtils;
import cn.itcast.utils.PageBean;

/**
 * 2. ���ݷ��ʲ�ʵ��
 * @author Jie.Yuan
 *
 */
public class EmployeeDao implements IEmployeeDao {

	@Override
	public void getAll(PageBean<Employee> pb) {
		//1. ��ȡ��ǰҳ�� �����ѯ����ʼ�С����ص�����
		int currentPage = pb.getCurrentPage();
		int index = (currentPage -1 ) * pb.getPageCount();		// ��ѯ����ʼ��
		int count = pb.getPageCount();
		
		//2. ��ѯ�ܼ�¼��;  ���õ�pb������
		int totalCount = this.getTotalCount();
		pb.setTotalCount(totalCount);
		
		/*
		 * ���⣺ jspҳ�棬�����ǰҳΪ��ҳ���ٵ����һҳ����
		 *              �����ǰҳΪĩҳ���ٵ���һҳ��ʾ�����⣡
		 * �����
		 * 	   1. �����ǰҳ <= 0;       ��ǰҳ���õ�ǰҳΪ1;
		 * 	   2. �����ǰҳ > ���ҳ����  ��ǰҳ����Ϊ���ҳ��
		 */
		// �ж�
		if (pb.getCurrentPage() <=0) {
			pb.setCurrentPage(1);					    // �ѵ�ǰҳ����Ϊ1
		} else if (pb.getCurrentPage() > pb.getTotalPage()){
			pb.setCurrentPage(pb.getTotalPage());		// �ѵ�ǰҳ����Ϊ���ҳ��
		}
		

		//3. ��ҳ��ѯ����;  �Ѳ�ѯ�����������õ�pb������
		String sql = "select * from employee limit ?,?";
		
		try {
			// �õ�Queryrunner����
			QueryRunner qr = JdbcUtils.getQueryRuner();
			// ���ݵ�ǰҳ����ѯ��ǰҳ����(һҳ����)
			List<Employee> pageData = qr.query(sql, new BeanListHandler<Employee>(Employee.class), index, count);
			// ���õ�pb������
			pb.setPageData(pageData);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	@Override
	public int getTotalCount() {
		String sql = "select count(*) from employee";
		try {
			// ����QueryRunner����
			QueryRunner qr = JdbcUtils.getQueryRuner();
			// ִ�в�ѯ�� ���ؽ���ĵ�һ�еĵ�һ��
			Long count = qr.query(sql, new ScalarHandler<Long>());
			return count.intValue();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

}














