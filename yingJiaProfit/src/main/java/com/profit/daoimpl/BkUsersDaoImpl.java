package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BkUsersDaoImpl {
	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List ListUser(){
		Session session = getSession();
		String sql="from Users where 0=0";
		List list=session.createQuery(sql).list();
		return list;
	}
}
