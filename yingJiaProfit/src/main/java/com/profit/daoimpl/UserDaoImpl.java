package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Users;


@Component
public class UserDaoImpl  {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public List ListAll() {
		Session session = getSession();
		 StringBuffer buffer = new StringBuffer();
         buffer.append( " from  Users  u  inner  join fetch u.userrole ");
        Query query = session.createQuery(buffer.toString());
		 List list =   query.list();
		 System.out.println(list.size());
		return list;
		
	}
	
	public  Users getByName(String name) {
		System.out.println(name);
		Session session=getSession();
		String hql="from Users u where u.user_name='"+name+"'";
		List<Users> list=session.createQuery(hql).list();
		System.out.println(list);
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	public List ListAlltrue(int id) {
		// TODO Auto-generated method stub
		return null;
	}


}