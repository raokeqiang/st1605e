package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.FinanciaPlanner;

@Component
public class FinanciaPlannerDao {
								//理财师管理
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<FinanciaPlanner> ListAll(Map map) {
		Session session = getSession();
		 String hql=" from FinanciaPlanner f where 0=0 ";
		hql=getHql(hql,map);
        List<FinanciaPlanner> list = session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
	    int member_id=(int)map.get("member_id");   
	    if(member_id!=0){
	    	hql+=" and f.member.id = "+member_id;
	    }
		return hql;
	}
	public FinanciaPlanner getById(int id) {
		Session session = getSession();
		FinanciaPlanner financiaPlanner=(FinanciaPlanner)session.get(FinanciaPlanner.class, id);
		return financiaPlanner;
	}
	
}
