package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.AwardRecords;
import com.profit.bean.FinanciaPlanner;
import com.profit.bean.SubjectPurchaseRecord;

@Component
public class SubjectPurchaseRecordDao {
                                  //标的购买表方法
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<SubjectPurchaseRecord> listAll(Map map) {
		Session session = getSession();
		 String hql="from SubjectPurchaseRecord s where 0=0 ";
		 hql=getHql(hql,map);
       List<SubjectPurchaseRecord> list=session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
	    int subject_id=0;
	    int member_id=0;
	    if(map.get("subject_id")!=null){
	    	subject_id=(int)map.get("subject_id");
	    	hql+=" and s.subject.id = "+subject_id;
	    }
	    if(map.get("member_id")!=null){
	    	member_id=(int)map.get("member_id");
	    	hql+=" and s.member.id = "+member_id;
	    }
		return hql;
	}
	public SubjectPurchaseRecord getById(int id) {
		Session session = getSession();
		SubjectPurchaseRecord subjectPurchaseRecord=(SubjectPurchaseRecord)session.get(SubjectPurchaseRecord.class, id);
		return subjectPurchaseRecord;
	}
	public void update(SubjectPurchaseRecord obj) {
		Session session = getSession();
		session.update(obj);
	}
}
