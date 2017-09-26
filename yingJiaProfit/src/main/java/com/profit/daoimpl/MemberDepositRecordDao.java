package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.FinanciaPlanner;
import com.profit.bean.MemberDepositRecord;

@Component
public class MemberDepositRecordDao {
									//充值管理方法
	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<MemberDepositRecord> ListAll(Map map) {
		Session session = getSession();
		 String hql=" from MemberDepositRecord m where 0=0 ";
		 hql=getHql(hql,map);
		 System.out.println("-------"+hql);
        List<MemberDepositRecord> list = session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
		String qorderno=(String)map.get("qorderno");
		String qmobile_Phone=(String)map.get("qmobile_Phone");
		String qstatus=(String)map.get("qstatus");
		String qfuiouno=(String)map.get("qfuiouno");
		String qtime=(String)map.get("qtime");
		int member_id=(int)map.get("member_id");
	      if(member_id!=0){     //根据member_id查询充值管理表 内容
	    	  hql+=" and m.member.id = "+member_id;
	      }
       if(qorderno!=null&&!qorderno.equals("")){
    	   hql+=" and m.pay_channel_order_no like '%"+qorderno+"%' ";
       }
       if(qmobile_Phone!=null&&!qmobile_Phone.equals("")){
    	   hql+=" and m.member.mobile_Phone like '%"+qmobile_Phone+"%' ";
       }
      if(qstatus!=null&&!qstatus.equals("")){
    	  hql+=" and m.status="+qstatus;
       }
      if(qfuiouno!=null&&!qfuiouno.equals("")){
    	  hql+=" and m.pay_channel_order_no like '%"+qfuiouno+"%' ";
      }
      if(qtime!=null&&!qtime.equals("")){
    	  hql+=" and m.create_date like '%"+qtime+"%' ";
      }
		return hql;
	}
	public MemberDepositRecord getById(int id) {
		Session session = getSession();
		MemberDepositRecord memberDepositRecord=(MemberDepositRecord)session.get(MemberDepositRecord.class, id);
		return memberDepositRecord;
	}
}
