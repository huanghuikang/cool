package cn.service;

import cn.entity.Admin;

/**
 * ����Աҵ���߼���ӿ�
 * @author Administrator
 * */

public interface IAdminService {

	//ע��
	void register(Admin admin);
	//��½
	Admin login(Admin admin);
}
