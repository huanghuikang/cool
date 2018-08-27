package cn.dao.Impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

import org.hibernate.SessionFactory;

import cn.dao.IBaseDao;


//����dao��ͨ�ò�����ϣ�����е�dao���̳д���

public class BaseDao<T> implements IBaseDao<T> {
	//��ǰ������ʵ�ʵ�bean����
	private Class<T> clazz;
	//��ȡ������
	private String className;
	//���䷺��
	public BaseDao() {
		 Type type = this.getClass().getGenericSuperclass();
		 //ת��Ϊ����������
		 ParameterizedType pt=(ParameterizedType)type;//BaseDao<Employee>
		 //�õ�ʵ������
		 Type types[] = pt.getActualTypeArguments();
		 //��ȡʵ������
		 clazz=(Class<T>) types[0];
		 className=clazz.getSimpleName();//���磺Employee
	}
	//����ע��
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory ) {
		this.sessionFactory=sessionFactory;
	}
	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	@Override
	public void save(T emp) {
		
		sessionFactory.getCurrentSession().save(emp);
	}

	@Override
	public void update(T emp) {
		sessionFactory.getCurrentSession().update(emp);
		
	}

	@Override
	public void delete(int id) {
		
		sessionFactory.getCurrentSession()
			.createQuery("delete from"+ className + "where id=?")
			.setParameter(0, id).executeUpdate();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T findById(int id) {
		
		return (T) sessionFactory.getCurrentSession().get(clazz,id );
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from"+className).list();
	}

}
