package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.UserRole;
import com.profit.bean.Users;

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
	
	public  List listRole(){
		Session session = getSession();
		String sql="from UserRole where 0=0";
		List rlist=session.createQuery(sql).list();
		return rlist;
	}
	
	public void saveUsers(Users users){
		Session session = getSession();
		session.save(users);
	}
	
	public UserRole selectRo(int rid){
		Session session = getSession();
		String sql="from UserRole where id="+rid;
		List<UserRole> uList=session.createQuery(sql).list();
		return uList.get(0);
	}
}
