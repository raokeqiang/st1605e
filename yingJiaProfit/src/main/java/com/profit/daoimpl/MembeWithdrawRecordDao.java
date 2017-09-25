package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberBankcards;

@Component
public class MembeWithdrawRecordDao {

	@Autowired
	public SessionFactory sessionFactory;

	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	public List<MembeWithdrawRecord> ListAll(Map map) {
		Session session = getSession();
		 String hql=" from MembeWithdrawRecord m where 0=0";
		 hql=getHql(hql,map);
        List<MembeWithdrawRecord> list = session.createQuery(hql).list();
		return list;
	}
	public String getHql(String hql,Map map){
		String qmember_name=(String)map.get("qmember_name");   
		String qmobile_Phone=(String)map.get("qmobile_Phone");     
		String qbank_card=(String)map.get("qbank_card");
		String qstatus=(String)map.get("qstatus");
		String qcreate_date=(String)map.get("qcreate_date");
		int member_id=0;
		 if(map.get("member_id")!=null){
		    	member_id=(int)map.get("member_id");
		    	hql+=" and m.member.id = "+member_id;
		    }
       if(qmember_name!=null&&!qmember_name.equals("")){
    	   hql+=" and m.member.member_name like '%"+qmember_name+"%' ";
       }
       if(qmobile_Phone!=null&&!qmobile_Phone.equals("")){
    	   hql+=" and m.member.mobile_Phone like '%"+qmobile_Phone+"%' ";
       }
      if(qbank_card!=null&&!qbank_card.equals("")){
    	  hql+=" and bank_card like '%"+qbank_card+"%' ";
       }
      if(qstatus!=null&&!qstatus.equals("")){
    	  hql+=" and status ="+qstatus;
      }
      if(qcreate_date!=null&&!qcreate_date.equals("")){
    	  hql+=" and create_date like '%"+qcreate_date+"%' ";
      }
		return hql;
	}
	public MembeWithdrawRecord getById(int id) {   ////根据id查询 提现管理表 内容
		Session session = getSession();
		MembeWithdrawRecord membeWithdrawRecord=(MembeWithdrawRecord)session.get(MembeWithdrawRecord.class, id);
		return membeWithdrawRecord;
	}
	public void update(MembeWithdrawRecord obj) {
		Session session = getSession();
		session.update(obj);
	}
}
