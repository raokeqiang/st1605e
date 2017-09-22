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
       List<SubjectBbinPurchassRecord> list=session.createQuery(hql).list();
       return list;
}
  public String getHql(String hql,Map map){
      int subject_id=(int)map.get("subject_id");   
        if(subject_id!=0){
       hql+=" and s.subject_id.id = "+subject_id;
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
