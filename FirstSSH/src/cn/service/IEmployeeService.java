package cn.service;

import java.util.List;

import cn.entity.Employee;

/**
 * Ա��ģ��ҵ���߼���ӿ�
 * @author Administrator
 * */

public interface IEmployeeService {

	//����Ա��
	void save(Employee emp);
	//����Ա����Ϣ
	void update(Employee emp);
	//����������ѯ
	Employee findById(int id);
	//��ѯȫ��
	List<Employee> getAll();
	//����Ա������������ѯ
	List<Employee> getAll(String empName);
	//��������ɾ��
	void delete(int id);
	//ɾ�����Ա��
	void deleteMany(int[] ids);
}
