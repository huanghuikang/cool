package cn.service;

import cn.entity.Admin;

/**
 * 管理员业务逻辑层接口
 * @author Administrator
 * */

public interface IAdminService {

	//注册
	void register(Admin admin);
	//登陆
	Admin login(Admin admin);
}
