package cn.action;

import cn.entity.Admin;
import cn.service.IAdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * ����Ա��½ע��ģ��
 * @author Administrator
 * 
 * */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	//�����������
	private Admin admin=new Admin();
	public void setAdmin(Admin admin) {
		this.admin=admin;
	}
	public Admin getAdmin() {
		return admin;
	}

	@Override
	public Admin getModel() {
		return admin;
	}
	
	//����Service
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService=adminService;
	}
	//��¼
	public String login(){
		//��¼��֤
		Admin adminInfo=adminService.login(admin);
		//��֤
		if(adminInfo==null) {
			//��½ʧ��
			return "loginFaild";
		}else {
			//��½�ɹ����������ݵ�session
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}
}
