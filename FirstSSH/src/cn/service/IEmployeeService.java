package cn.service;

import java.util.List;

import cn.entity.Employee;

/**
 * 员工模块业务逻辑层接口
 * @author Administrator
 * */

public interface IEmployeeService {

	//保存员工
	void save(Employee emp);
	//更新员工信息
	void update(Employee emp);
	//根据主键查询
	Employee findById(int id);
	//查询全部
	List<Employee> getAll();
	//根据员工名称条件查询
	List<Employee> getAll(String empName);
	//根据主键删除
	void delete(int id);
	//删除多个员工
	void deleteMany(int[] ids);
}
