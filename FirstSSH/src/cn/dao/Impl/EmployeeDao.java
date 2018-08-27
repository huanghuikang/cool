package cn.dao.Impl;

import java.util.List;

import cn.dao.IEmployeeDao;
import cn.entity.Employee;

public class EmployeeDao extends BaseDao<Employee> implements IEmployeeDao {

	@Override
	public void save(Employee emp) {
		

	}

	@Override
	public void update(Employee emp) {
		

	}

	@Override
	public void delete(int id) {
		

	}

	@Override
	public Employee findById(int id) {
		
		return (Employee) getSessionFactory().getCurrentSession()
				.createQuery("from people.employee where eid=?")
				.setParameter(0, id)
				.uniqueResult();
	}

	@Override
	public List<Employee> getAll() {
		
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getAll(String empName) {
		
		return getSessionFactory().getCurrentSession()
				.createQuery("from people.employee where empName list ?")
				.setParameter(0, "%"+empName+"%")
				.list();
	}

}
