package cn.itcast.dao;

import cn.itcast.entity.Employee;
import cn.itcast.utils.PageBean;

/**
 * 2. ���ݷ��ʲ㣬�ӿ����
 * @author Jie.Yuan
 *
 */
public interface IEmployeeDao {

	/**
	 * ��ҳ��ѯ����
	 */
	public void getAll(PageBean<Employee> pb);
	
	/**
	 * ��ѯ�ܼ�¼��
	 */
	public int getTotalCount();
}









