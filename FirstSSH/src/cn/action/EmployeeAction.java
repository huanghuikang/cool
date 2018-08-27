package cn.action;

import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import cn.entity.Dept;
import cn.entity.Employee;
import cn.service.IDeptService;
import cn.service.IEmployeeService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 员工模块控制器开发：
 * 1.员工列表展示
 * 2.添加员工
 * 3.修改员工信息
 * 4.删除
 * @author Administrator
 *
 * */

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>,RequestAware {
	//封闭数据
	private Employee employee=new Employee();//模型驱动
	//封闭请求的部门id(下拉列表的实际的值)
	private int dId;
	public void setEmployee(Employee employee) {
		this.employee=employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	public int getDeptId() {
		return dId;
	}
	public void setDeptId(int deptId) {
		this.dId = deptId;
	}
	//接收框架运行时候传入的代表request对象的map
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//注入员工Service
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	//部门Service
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	//员工列表展示
	public String list() {
		//查询所有员工
		List<Employee> listEmp=employeeService.getAll();
		//保存到request
		request.put("listEmp", listEmp);
		return "list";
	}
	//添加员工 - 进入添加页面
	public String viewAdd() {
		//查询所有部门信息，保存到request
		List<Dept> listDept=deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	//添加员工数据
	public String save() {
		//先根据部门主键查询
		Dept dept=deptService.findById(dId);
		//设置到员工对象中
		employee.setDept(dept);
		//调用Service，保存员工
		employeeService.save(employee);
		return "listAction";
	}
	//修改员工信息 - 进入修改视图
	public String viewUpdate() {
		//获取要修改的记录的id
		int id=employee.getId();
		//根据员工的主键查询（lazy="false"）
		Employee emp=employeeService.findById(id);
		//查询所有的部门
		List<Dept> listDept=deptService.getAll();
		//数据回显
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.pop();//移除桟顶元素
		vs.push(emp);//入栈
		//保存
		request.put("listDept", listDept);
		return "edit";
	}
	//修改员工信息 - 确认修改
	public String update() {
		//先根据部门id,查询部门对象，再设置到员工属性
		Dept dept=deptService.findById(dId);
		employee.setDept(dept);
		//更新员工
		employeeService.update(employee);
		return "listAction";
	}
	//删除员工信息
	public String delete() {
		//获取要删除员工的主键
		int empId=employee.getId();
		//调用service删除
		employeeService.delete(empId);
		return "listAction";
	}
	
}
