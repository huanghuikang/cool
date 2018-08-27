package cn.service.Impl;

import cn.dao.IAdminDao;
import cn.entity.Admin;
import cn.service.IAdminService;

public class AdminService implements IAdminService {
	//注入dao【这里一定要用接口接收】
	private IAdminDao adminDao;
	public void setAdminDao(IAdminDao adminDao) {
		this.adminDao=adminDao;
	}
	@Override
	public void register(Admin admin) {

		adminDao.save(admin);
	}

	@Override
	public Admin login(Admin admin) {
		return adminDao.findByAdmin(admin);
	}

}
