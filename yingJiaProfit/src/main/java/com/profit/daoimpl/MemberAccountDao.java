package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberAccount;


@Component 
public class MemberAccountDao {
										//用户关联方法
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<MemberAccount> ListAll(Map map) {
		Session session = getSession();
		 String hql=" from MemberAccount m where 0=0 ";
		 hql=getHql(hql,map);
        List<MemberAccount> list = session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
	    int member_id=(int)map.get("member_id");   
       if(member_id!=0){     //根据member_id查询 用户关联表 内容
    	   hql+=" and m.member.id = "+member_id;
       }
		return hql;
	}
	public MemberAccount getById(int id) {   
		Session session = getSession();
		MemberAccount membeWithdrawRecord=(MemberAccount)session.get(MemberAccount.class, id);
		return membeWithdrawRecord;
	}
}


