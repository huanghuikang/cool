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
 * Ա��ģ�������������
 * 1.Ա���б�չʾ
 * 2.���Ա��
 * 3.�޸�Ա����Ϣ
 * 4.ɾ��
 * @author Administrator
 *
 * */

public class EmployeeAction extends ActionSupport implements ModelDriven<Employee>,RequestAware {
	//�������
	private Employee employee=new Employee();//ģ������
	//�������Ĳ���id(�����б��ʵ�ʵ�ֵ)
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
	//���տ������ʱ����Ĵ���request�����map
	private Map<String, Object> request;
	@Override
	public void setRequest(Map<String, Object> request) {
		this.request=request;
	}
	@Override
	public Employee getModel() {
		return employee;
	}
	
	//ע��Ա��Service
	private IEmployeeService employeeService;
	public void setEmployeeService(IEmployeeService employeeService) {
		this.employeeService = employeeService;
	}
	//����Service
	private IDeptService deptService;
	public void setDeptService(IDeptService deptService) {
		this.deptService = deptService;
	}
	//Ա���б�չʾ
	public String list() {
		//��ѯ����Ա��
		List<Employee> listEmp=employeeService.getAll();
		//���浽request
		request.put("listEmp", listEmp);
		return "list";
	}
	//���Ա�� - �������ҳ��
	public String viewAdd() {
		//��ѯ���в�����Ϣ�����浽request
		List<Dept> listDept=deptService.getAll();
		request.put("listDept", listDept);
		return "add";
	}
	//���Ա������
	public String save() {
		//�ȸ��ݲ���������ѯ
		Dept dept=deptService.findById(dId);
		//���õ�Ա��������
		employee.setDept(dept);
		//����Service������Ա��
		employeeService.save(employee);
		return "listAction";
	}
	//�޸�Ա����Ϣ - �����޸���ͼ
	public String viewUpdate() {
		//��ȡҪ�޸ĵļ�¼��id
		int id=employee.getId();
		//����Ա����������ѯ��lazy="false"��
		Employee emp=employeeService.findById(id);
		//��ѯ���еĲ���
		List<Dept> listDept=deptService.getAll();
		//���ݻ���
		ValueStack vs=ActionContext.getContext().getValueStack();
		vs.pop();//�Ƴ��C��Ԫ��
		vs.push(emp);//��ջ
		//����
		request.put("listDept", listDept);
		return "edit";
	}
	//�޸�Ա����Ϣ - ȷ���޸�
	public String update() {
		//�ȸ��ݲ���id,��ѯ���Ŷ��������õ�Ա������
		Dept dept=deptService.findById(dId);
		employee.setDept(dept);
		//����Ա��
		employeeService.update(employee);
		return "listAction";
	}
	//ɾ��Ա����Ϣ
	public String delete() {
		//��ȡҪɾ��Ա��������
		int empId=employee.getId();
		//����serviceɾ��
		employeeService.delete(empId);
		return "listAction";
	}
	
}
