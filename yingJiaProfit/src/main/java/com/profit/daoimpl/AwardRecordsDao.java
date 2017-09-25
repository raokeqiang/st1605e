package com.profit.daoimpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.AwardRecords;
import com.profit.bean.Range;

@Component
public class AwardRecordsDao {
							   		//邀请管理
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<AwardRecords> ListAll(Map map) {
		Session session = getSession();
		String hql="from AwardRecords a where 0=0 ";
		hql=getHql(hql,map);
		List<AwardRecords> list=session.createQuery(hql).list();
		System.out.println(hql);
		return list;
	}
	public List<Range> ListRangeAll(Map map) {
		Session session = getSession();
		 String sql="select * from (select mobile_Phone,member_name,invitationCode,invitedCode,sum(invest_amount) amount,case when max(enroll)=0 then '0' when max(enroll)=2 then '2' when max(enroll)=1 then '1'else '0' end enroll,case when max(invest)=0 then '0' when max(invest)=2 then'2' when max(invest)=1 then'1'else '0' end invest,max(create_date) create_date from(select  m.mobile_Phone,m.member_name,m.invitationCode,m.invitedCode,mm.invest_amount,case when a.type=0 and a.isAward=1 then '2' when a.type=0 and a.isAward!=1 then '1' else '0' end enroll,case when a.type=1  and a.isAward=1 then '2' when a.type=1  and a.isAward!=1 then '1' else '0' end invest,m.create_date from award_records a left join member m on a.invitingid=m.id left join member_account mm on m.id=mm.member_id)t group by t.mobile_Phone,t.member_name,t.invitationCode,t.invitedCode)tt where 0=0 ";
          sql=getsql(sql,map);
		  List list=session.createSQLQuery(sql).list();
          List<Range> listrange=new ArrayList<Range>();
        for(int i=0;i<list.size();i++){
        	Object[] obj=(Object[])list.get(i);
        	   Range range=new Range();
               range.setMobile_Phone(obj[0].toString());
               range.setMember_name(obj[1].toString());
               range.setInvitationCode(obj[2].toString());
               range.setInvitedCode(obj[3].toString());
               int amous=0;
        	   if(obj[4]==null){
        		   amous=0;
        	   }else{
        		   amous=(int)Float.parseFloat(obj[4].toString());
        	   }
               range.setAmount(amous);
               range.setEnroll(obj[5].toString());
               range.setInvest(obj[6].toString());
               range.setCreate_date(obj[7].toString());
              listrange.add(range);
        }
		return listrange;
	}
	public String getsql(String sql,Map map){
		String qmember_name=(String)map.get("qmember_name");   
		String qmobile_Phone=(String)map.get("qmobile_Phone");     
		String qinvitationCode=(String)map.get("qinvitationCode");
		String qinvitedCode=(String)map.get("qinvitedCode");
		String qenroll=(String)map.get("qenroll");
		String qinvest=(String)map.get("qinvest");
		
       if(qmember_name!=null&&!qmember_name.equals("")){
    	   sql+=" and tt.member_name like '%"+qmember_name+"%' ";
       }
       if(qmobile_Phone!=null&&!qmobile_Phone.equals("")){
    	   sql+=" and tt.mobile_Phone like '%"+qmobile_Phone+"%' ";
       }
      if(qinvitationCode!=null&&!qinvitationCode.equals("")){
    	   sql+=" and tt.invitationCode like '%"+qinvitationCode+"%' ";
       }
      if(qinvitedCode!=null&&!qinvitedCode.equals("")){
    	   sql+=" and tt.invitedCode like '%"+qinvitedCode+"%' ";
      }
      if(qenroll!=null&&!qenroll.equals("")){
    	   if(qenroll.equals("2")){
    		   sql+=" and tt.enroll ='2'";
    	   }else{
    		   sql+=" and tt.enroll !='2'";
    	   }
      }
      if(qinvest!=null&&!qinvest.equals("")){
    	  if(qinvest.equals("2")){
    		  sql+=" and tt.invest ='2'";
   	   }else{
   		    sql+=" and tt.invest !='2'";
   	   }
      }
		return sql;
	}
	public String getHql(String hql,Map map){
		String phone=(String)map.get("phone");
		 if(phone!=null&&!phone.equals("")){
	    	   hql+=" and a.invitingid.mobile_Phone ="+phone;
	       }
		 return hql;
	}
	public AwardRecords getById(int id) {
		Session session=getSession();
		AwardRecords awardRecords=(AwardRecords)session.get(AwardRecords.class,id);
		return awardRecords;
	}
    public void update(AwardRecords obj) {
		Session session=getSession();
		session.update(obj);
	}
}
