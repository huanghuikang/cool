package cn.dao;

import cn.entity.Admin;

/**
 * 管理员模块dao接口
 * @author Administrator
 * */
public interface IAdminDao {

	//保存
	void save(Admin admin);
	//根据管理员信息查询
	Admin findByAdmin(Admin admin);
}
