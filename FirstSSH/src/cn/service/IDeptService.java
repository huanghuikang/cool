package cn.service;

import java.util.List;

import cn.entity.Dept;

/**
 * ����ģ��ҵ���߼���ӿ�
 * @author Administrator
 * 
 * */
public interface IDeptService {
	//��ѯȫ��
	List<Dept> getAll();
	//����������ѯ
	Dept findById(int id);
}
