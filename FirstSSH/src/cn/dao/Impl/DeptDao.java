package cn.dao.Impl;

import java.util.List;

import org.hibernate.SessionFactory;

import cn.dao.IDeptDao;
import cn.entity.Dept;

public class DeptDao implements IDeptDao {
	
	private SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Dept> getAll() {
		
		return sessionFactory.getCurrentSession().createQuery("from people.dept").list();
	}

	@Override
	public Dept findById(int id) {
		
		return (Dept) sessionFactory.getCurrentSession().get(Dept.class, id);
	}

}
