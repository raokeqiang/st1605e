package com.profit.daoimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberTradeRecord;
import com.profit.dao.MemberTradeRecordDao;
@Component
public class MemberTradeRecordDaoImpl implements MemberTradeRecordDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public Session getsession(){
		return sessionFactory.getCurrentSession();
	}
	
	public List<MemberTradeRecord> listAll(Map map){
		String hql=" from MemberTradeRecord m where 0=0 ";
		Session session=getsession();
		hql=listhql(map, hql);
		List<MemberTradeRecord> memberTradeRecordList=session.createQuery(hql).list();
		return memberTradeRecordList;
	}
	
	public String listhql(Map map,String hql){
		String qtrade_no=(String)map.get("qtrade_no");
		String qmobile_Phone=(String)map.get("qmobile_Phone");
		String qtrade_type=(String)map.get("qtrade_type");
		Integer qtrade_status=(Integer)map.get("qtrade_status");
		if(qtrade_no!=null&&!qtrade_no.equals("")){
			hql+=" and m.trade_no like '%"+qtrade_no+"%'";
		}
		if(qmobile_Phone!=null&&!qmobile_Phone.equals("")){
			hql+=" and m.member.mobile_Phone like '%"+qmobile_Phone+"%'";
		}
		if(qtrade_type!=null&&!qtrade_type.equals("")){
			hql+=" and m.trade_type ='"+qtrade_type+"'";
		}
		if(qtrade_status!=null&&!qtrade_status.equals("")){
			hql+=" and m.trade_status ="+qtrade_status+"";
		}
		return hql;
	}
}
