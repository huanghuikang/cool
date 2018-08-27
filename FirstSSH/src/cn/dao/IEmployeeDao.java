package cn.dao;

import java.util.List;

import cn.entity.Employee;

public interface IEmployeeDao {

	//����Ա��
	void save(Employee emp);
	//����Ա����Ϣ
	void update(Employee emp);
	//��������ɾ��
	void delete(int id);
	//����������ѯ
	Employee findById(int id);
	//��ѯȫ��
	List<Employee> getAll();
	//����Ա������������ѯ
	List<Employee> getAll(String empName );
}
