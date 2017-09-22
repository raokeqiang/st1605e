package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberAccount;

@Component
public class FrontMemberAccountDaoImpl {
	
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public MemberAccount selectMA(int member_id){
		String hql = "from MemberAccount where member_id ="+member_id;
		List memberAccount= getSession().createQuery(hql).list();
		if(memberAccount.size()>0){
			return (MemberAccount) memberAccount.get(0);
		}
		return null;
	}
}
