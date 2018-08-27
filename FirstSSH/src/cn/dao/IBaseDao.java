package cn.dao;

import java.util.List;

/**
 * 
 * ����dao��ͨ�ò����ӿڶ���
 * @author Administrator
 * 
 * */
public interface IBaseDao<T> {

	//����
	void save(T emp);
	//���¶�����Ϣ
	void update(T emp);
	//��������ɾ��
	void delete(int id);
	//����������ѯ
	T findById(int id);
	//��ѯȫ��
	List<T> getAll();
}
