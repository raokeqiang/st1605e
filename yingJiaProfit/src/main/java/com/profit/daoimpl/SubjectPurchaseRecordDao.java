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
       List<SubjectPurchaseRecord> list=session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
	    int subject_id=(int)map.get("subject_id");   
	    if(subject_id!=0){
	    	hql+=" and s.subject_id.id = "+subject_id;
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
