package cn.itcast.service;

import cn.itcast.entity.Employee;
import cn.itcast.utils.PageBean;

/**
 * 3. ҵ���߼���ӿ����
 * @author Jie.Yuan
 *
 */
public interface IEmployeeService {

	/**
	 * ��ҳ��ѯ����
	 */
	public void getAll(PageBean<Employee> pb);
}
