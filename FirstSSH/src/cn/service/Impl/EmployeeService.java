package cn.service.Impl;

import java.util.List;

import cn.dao.IEmployeeDao;
import cn.entity.Employee;
import cn.service.IEmployeeService;

public class EmployeeService implements IEmployeeService {
	
	//×¢ÈëDao
	private IEmployeeDao employeeDao;
	public void setEmployee(IEmployeeDao employeeDao ) {
		this.employeeDao=employeeDao;
	}

	@Override
	public void save(Employee emp) {
		employeeDao.save(emp);

	}

	@Override
	public void update(Employee emp) {
		employeeDao.update(emp);

	}

	@Override
	public Employee findById(int id) {
		
		return employeeDao.findById(id);
	}

	@Override
	public List<Employee> getAll() {
		
		return employeeDao.getAll();
	}

	@Override
	public List<Employee> getAll(String empName) {
		
		return employeeDao.getAll(empName);
	}

	@Override
	public void delete(int id) {
		employeeDao.delete(id);

	}

	@Override
	public void deleteMany(int[] ids) {
		if(ids!=null && ids.length >0) {
			for(int id:ids) {
				delete(id);
			}
		}

	}

}
