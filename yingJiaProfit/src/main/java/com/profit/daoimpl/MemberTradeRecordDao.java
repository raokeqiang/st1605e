package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberTradeRecord;

@Component
public class MemberTradeRecordDao {
									//交易记录表
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<MemberTradeRecord> ListAll(Map map) {
		Session session = getSession();
		 String hql=" from MemberTradeRecord m where 0=0 ";
		hql=getHql(hql,map);
        List<MemberTradeRecord> list = session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
	    int member_id=(int)map.get("member_id");   
	    if(member_id!=0){
	    	hql+=" and m.member.id = "+member_id;
	    }
		return hql;
	}
	public MemberTradeRecord getById(int id) {
		Session session = getSession();
		MemberTradeRecord memberTradeRecord=(MemberTradeRecord)session.get(MemberTradeRecord.class, id);
		return memberTradeRecord;
	}
}
