package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberBankcards;

@Component
public class MemberBankcardsDao {
									//绑卡管理
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<MemberBankcards> ListAll(Map map) {
		Session session = getSession();
		 String hql=" from MemberBankcards m where 0=0 ";
		 hql=getHql(hql,map);
        List<MemberBankcards> list = session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
		String qmobile_Phone=(String)map.get("qmobile_Phone");   
		String qmember_name=(String)map.get("qmember_name");     
		String qcard_no=(String)map.get("qcard_no");
		String qcreate_date=(String)map.get("qcreate_date");
       if(qmobile_Phone!=null&&!qmobile_Phone.equals("")){
    	   hql+=" and m.member.mobile_Phone like '%"+qmobile_Phone+"%' ";
       }
       if(qmember_name!=null&&!qmember_name.equals("")){
    	   hql+=" and m.member.member_name like '%"+qmember_name+"%' ";
       }
      if(qcard_no!=null&&!qcard_no.equals("")){
    	  hql+=" and card_no like '%"+qcard_no+"%' ";
       }
      if(qcreate_date!=null&&!qcreate_date.equals("")){
    	  hql+=" and create_date like '%"+qcreate_date+"%' ";
      }
		return hql;
	}
	public void update(MemberBankcards obj) {
		Session session = getSession();
		session.update(obj);
	}
	public MemberBankcards getById(int id) {
		Session session = getSession();
		MemberBankcards memberBankcards=(MemberBankcards)session.get(MemberBankcards.class, id);
		return memberBankcards;
	}
	
}
