package com.profit.daoimpl;

import java.util.List;

//登陆相关的Dao方法

import org.hibernate.Session;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Member;
import com.profit.bean.MemberBankcards;

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
	
	
	//前台注册
	public void saveMember(Member member){
		Session session=getSession();
		session.save(member);
	}
	
	public MemberBankcards getMemberBankcards(int member_id){
		String sql="from MemberBankcards  where member_id="+member_id;
		List <MemberBankcards> list=getSession().createQuery(sql).list();
		if(list.size()!=0){
			return list.get(0);
		}
		return null;
	}
	public void updatepwd(Member member){
		Session session=getSession();
		session.update(member);
	}
}
