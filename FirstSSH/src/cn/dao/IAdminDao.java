package cn.dao;

import cn.entity.Admin;

/**
 * ����Աģ��dao�ӿ�
 * @author Administrator
 * */
public interface IAdminDao {

	//����
	void save(Admin admin);
	//���ݹ���Ա��Ϣ��ѯ
	Admin findByAdmin(Admin admin);
}
