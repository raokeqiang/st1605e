package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.SubjectBbinPurchassRecord;

@Component
public class SubjectBbinPurchassRecordDao {

                                        //体验金购买表方法
@Autowired
 public SessionFactory sessionFactory;

  public Session getSession() {
       return sessionFactory.getCurrentSession();
  }
  public List<SubjectBbinPurchassRecord> listAll(Map map) {
       Session session = getSession();
       String hql="from SubjectBbinPurchassRecord s where 0=0 ";
       hql=getHql(hql,map);
       List<SubjectBbinPurchassRecord> list=session.createQuery(hql).list();
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
public SubjectBbinPurchassRecord getById(int id) {
        Session session = getSession();
        SubjectBbinPurchassRecord subjectBbinPurchassRecord=(SubjectBbinPurchassRecord)session.get(SubjectBbinPurchassRecord.class, id);
     return subjectBbinPurchassRecord;
}
public void update(SubjectBbinPurchassRecord obj) {
	 Session session = getSession();
	 session.update(obj);
}
}
