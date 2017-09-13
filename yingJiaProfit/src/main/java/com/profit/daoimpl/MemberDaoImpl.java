package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Member;
import com.profit.bean.UserRole;
import com.profit.dao.RoleDao;

@Component
public class MemberDaoImpl  implements RoleDao<Member>{

	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	@Override
	public List<Member> listRole() {
		return null;
	}
	//查询账号的Dao方法
	@Override
	public List<Member> listMemder() {
		Session  session=getSession();
		String hql="from Member";
		List<Member> list=session.createQuery(hql).list();
		return list;
	}

}
