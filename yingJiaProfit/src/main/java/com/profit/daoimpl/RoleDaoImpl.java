package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.UserRole;
import com.profit.dao.RoleDao;

@Component
public class RoleDaoImpl implements RoleDao {
	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	//查询角色
	public List<UserRole> listRole(){
		Session  session=getSession();
		String hql="from UserRole";
		List<UserRole> list=session.createQuery(hql).list();
		return list;
	}
	
	

}
