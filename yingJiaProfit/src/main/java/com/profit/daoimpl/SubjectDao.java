package com.profit.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.activiti.engine.impl.cmd.SetExecutionVariablesCmd;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Range;
import com.profit.bean.Subject;
import com.profit.bean.SubjectPurchaseRecord;

@Component
public class SubjectDao {
	                             //付息计划
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<Subject> ListAll(Map map) {
		Session session = getSession();
		 String hql="from Subject where 0=0 ";
        List<Subject> list = session.createQuery(hql).list();
		return list;
	}
	public List<SubjectPurchaseRecord> listRange(Map map) {
		Session session = getSession();
		 String sql="select * from(select s1.serial_no,s1.type,s1.name,s1.amount,SUM(s2.amount*s2.pay_interest_times) sumamount,s1.bought,s1.period,s1.year_rate,s1.status,s1.exper_status,s1.id subject_id from subject s1 left join subject_purchase_record s2 on s1.id=s2.subject_id group by s1.serial_no,s1.type,s1.name,s1.amount,s1.bought,s1.period,s1.year_rate,s1.status,s1.exper_status,s1.id)t where 0=0 ";
		 sql=getsql(sql,map);
		 List list = session.createSQLQuery(sql).list();
        List<SubjectPurchaseRecord> listrange=new ArrayList<SubjectPurchaseRecord>();
        for(int i=0;i<list.size();i++){
        	Object[] obj=(Object[])list.get(i);
        	SubjectPurchaseRecord subjectPurchaseRecord=new SubjectPurchaseRecord();
        	   Subject subject=new Subject();
        	   subject.setSerial_no(obj[0].toString());
        	   subject.setType(Integer.parseInt(obj[1].toString()));
        	   subject.setName(obj[2].toString());
        	   subject.setAmount((int)Float.parseFloat(obj[3].toString()));
        	   
        	   subject.setBought(Integer.parseInt(obj[5].toString()));
        	   subject.setPeriod(Integer.parseInt(obj[6].toString()));
        	   subject.setYear_rate((int)Float.parseFloat(obj[7].toString()));
        	   subject.setStatus(Integer.parseInt(obj[8].toString()));
        	   subject.setExper_status(Integer.parseInt(obj[9].toString()));
        	   if(obj[10]==null){
        		   subject.setId(0);
        	   }else{
        		   subject.setId(Integer.parseInt(obj[10].toString()));
        	   }
        	  
        	  subjectPurchaseRecord.setSubject_id(subject);
        	  int ams;
       	      if(obj[4]==null){
       		   ams=0;
       	      }else{
       		   ams=(int)Float.parseFloat(obj[4].toString());
       	      }
       	      subjectPurchaseRecord.setAmount(ams);
              listrange.add(subjectPurchaseRecord);
        }
        
		return listrange;
	}
public String getsql(String sql,Map map){
		String qname=(String)map.get("qname");   
		String qstatus=(String)map.get("qstatus");     
		String qtype=(String)map.get("qtype");
		
       if(qname!=null&&!qname.equals("")){
    	   sql+=" and t.name like '%"+qname+"%' ";
       }
       if(qstatus!=null&&!qstatus.equals("")){
    	   int stat=Integer.parseInt(qstatus);
    	   sql+=" and t.status ="+qstatus;
       }
      if(qtype!=null&&!qtype.equals("")){
    	  int typ=Integer.parseInt(qtype);
    	   sql+=" and t.type ="+typ;
       }
		return sql;
	}
}
