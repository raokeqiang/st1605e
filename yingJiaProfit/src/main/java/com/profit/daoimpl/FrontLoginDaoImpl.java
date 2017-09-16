package com.profit.daoimpl;

import java.util.List;

//登陆相关的Dao方法

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Member;

@Component
public class FrontLoginDaoImpl {
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public boolean checkUserLogin(String mobelPhone,String password){
		String sql="select count(*) from member where mobile_Phone='"+mobelPhone+"'"
				+ " and password = '"+password+"'";
		String cnt=getSession().createSQLQuery(sql).uniqueResult().toString();
		System.out.println(cnt);
		if(Integer.parseInt(cnt)>0){
			return true;
		}
		return false;
	}

	public Member getMemberByPhone (String phone){
		String hql="from Member m where m.mobile_Phone='"+phone+"'";
		List<Member> memberList=getSession().createQuery(hql).list();
		if (memberList.size()>0) {
			return memberList.get(0);
		}
		return null;
	}
}
