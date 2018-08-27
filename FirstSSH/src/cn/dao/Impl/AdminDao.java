package cn.dao.Impl;

import org.hibernate.SessionFactory;
import org.omg.CORBA.PRIVATE_MEMBER;

import cn.dao.IAdminDao;
import cn.entity.Admin;

public class AdminDao implements IAdminDao {
	
	//IOC»›∆˜£®“¿¿µ£©◊¢»ÎSessionFactory∂‘œÛ
	private SessionFactory sessionFactiory;
	public void setSessionFactiory(SessionFactory sessionFactory) {
		this.sessionFactiory=sessionFactory;
	}
	@Override
	public void save(Admin admin) {

		sessionFactiory.getCurrentSession().save(admin);
	}

	@Override
	public Admin findByAdmin(Admin admin) {
		return (Admin) sessionFactiory.getCurrentSession()
				.createQuery("from people.admin where adminName=? and pwd=?")
				.setString(0, admin.getAdminName())
				.setString(1, admin.getPwd())
				.uniqueResult();
	}

}
