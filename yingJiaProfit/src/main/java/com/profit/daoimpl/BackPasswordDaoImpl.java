package com.profit.daoimpl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BackPasswordDaoImpl {
	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public void updateUsers(String password,String user_name) {
		Session session = getSession();
		String sql="update users set password='"+password+"' where user_name= '"+user_name+"'";
		session.createSQLQuery(sql).executeUpdate();
	}
	
	public void updateUsers1(String password2,String password1) {
		Session session = getSession();
		String sql="update member set password= '"+password2+"' where password= '"+password1+"'";
		session.createSQLQuery(sql).executeUpdate();
	}
	

}
