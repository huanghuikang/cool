package cn.dao;

import java.util.List;

import cn.entity.Dept;

/**
 * 
 * ����ģ��dao�ӿ����
 * @author Administrator
 * 
 * */

public interface IDeptDao {

	//��ѯȫ��
	List<Dept> getAll();
	//����������ѯ
	Dept findById(int id);
}
