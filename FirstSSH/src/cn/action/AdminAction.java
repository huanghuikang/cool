package cn.action;

import cn.entity.Admin;
import cn.service.IAdminService;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.org.apache.bcel.internal.generic.NEW;

/**
 * 管理员登陆注册模块
 * @author Administrator
 * 
 * */
public class AdminAction extends ActionSupport implements ModelDriven<Admin> {
	//封闭请求数据
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
	
	//调用Service
	private IAdminService adminService;
	public void setAdminService(IAdminService adminService) {
		this.adminService=adminService;
	}
	//登录
	public String login(){
		//登录验证
		Admin adminInfo=adminService.login(admin);
		//验证
		if(adminInfo==null) {
			//登陆失败
			return "loginFaild";
		}else {
			//登陆成功，保存数据到session
			ActionContext.getContext().getSession().put("adminInfo", adminInfo);
			return "index";
		}
	}
}
