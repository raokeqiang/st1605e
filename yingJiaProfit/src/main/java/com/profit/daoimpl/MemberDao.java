package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Member;

@Component 
public class MemberDao {
										//用户管理
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<Member> ListAll(Map map) {
		Session session = getSession();
		 String hql=" from Member where 0=0 ";
		hql=getHql(hql,map);
        List<Member> list = session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
		String qname=(String)map.get("qname");
		String qmember_name=(String)map.get("qmember_name");
		String qmobile_Phone=(String)map.get("qmobile_Phone");
		String qinvitationCode=(String)map.get("qinvitationCode");
		String qcreate_date=(String)map.get("qcreate_date");
       if(qname!=null&&!qname.equals("")){
    	   hql+=" and name like '%"+qname+"%' ";
       }
       if(qmember_name!=null&&!qmember_name.equals("")){
    	   hql+=" and member_name like '%"+qmember_name+"%' ";
       }
      if(qmobile_Phone!=null&&!qmobile_Phone.equals("")){
    	  hql+=" and mobile_Phone like '%"+qmobile_Phone+"%' ";
       }
      if(qinvitationCode!=null&&!qinvitationCode.equals("")){
    	  hql+=" and invitationCode like '%"+qinvitationCode+"%' ";
      }
      if(qcreate_date!=null&&!qcreate_date.equals("")){
    	  hql+=" and create_date like '%"+qcreate_date+"%' ";
      }
		return hql;
	}
	public Member getById(int id) {
		Session session = getSession();
		Member member=(Member)session.get(Member.class, id);
		return member;
	}
}


