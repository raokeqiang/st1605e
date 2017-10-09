package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.dao.FinancialDao;
@Component
public class FinancialDaoImpl implements FinancialDao{

	@Autowired
	private SessionFactory sf;
	
	public Session getSession(){
		return sf.getCurrentSession();
	}
	public List<AwardRecords> lsa(String iphone,String start) {
		Session session=getSession();
		String hql="select SUM(amount) from award_records where 0=0";
		 List<com.profit.bean.Member> m=lsm(iphone);
			int i=m.get(0).getId();
			if(start!=null&&!"".equals(start)){
	       		 hql+=" and addTime like '%"+start+"%'";
	       	 }
			if(i!=0){
				hql+=" and invitingid ='"+i+"' GROUP BY invitingid";
			}
		
    	
			System.out.println(hql);
		List list=session.createSQLQuery(hql).list();
		return list;
	}

	public List<Member> lsm(String iphone) {
		Session session=getSession();
		String hql=" from Member where 0=0";
		if(iphone!=null&&!"".equals(iphone)){
			hql+=" and mobile_Phone ='"+iphone+"'";
		}
		
		System.out.println(hql);
		List<Member> list=session.createQuery(hql).list();
		return list;
	} 

	public List<MemberDepositRecord> lsmdr(String iphone,String start) {
		Session session=getSession();
		String hql="select SUM(amount) from member_deposit_record where 0=0  ";
		 List<Member> m=lsm(iphone);
			int i=m.get(0).getId();
			if(start!=null&&!"".equals(start)){
	       		 hql+=" and create_date like '%"+start+"%'";
	       	 }
			if(i!=0){
				hql+=" and member_id ='"+i+"' GROUP BY member_id" ;
			}
			
			System.out.println(hql);
		List list=session.createSQLQuery(hql).list();
		return list;
	}

	public List<Member_tally> lsmt(String iphone,String start) {
		Session session=getSession();
		String hql="select SUM(amount) from member_tally where 0=0";
		 List<Member> m=lsm(iphone);
			int i=m.get(0).getId();
			if(i!=0){
				hql+=" and member_id ='"+i+"' GROUP BY member_id";
			}
			if(start!=null&&!"".equals(start)){
	       		 hql+=" and create_date like '%"+start+"%'";
	       	 }
			System.out.println(hql);
		List list=session.createSQLQuery(hql).list();
		return list;
	}

	public List<MembeWithdrawRecord> lsmw(String iphone,String start) {
		Session session=getSession();
		String hql="select SUM(amount) from member_withdraw_record where 0=0";
		 List<Member> m=lsm(iphone);
			int i=m.get(0).getId();
			if(start!=null&&!"".equals(start)){
	       		 hql+=" and create_date like '%"+start+"%'";
	       	 }
			if(i!=0){
				hql+=" and member_id ='"+i+"' GROUP BY member_id";
			}
			System.out.println(hql);
		List list=session.createSQLQuery(hql).list();
		return list;
	}

	public List<MemberTradeRecord> lst(String iphone,String start,String type,String zhifu) {
		Session session=getSession();
		String hql=" from MemberTradeRecord where 0=0";
		 List<Member> m=lsm(iphone);
			int i=m.get(0).getId();
			if(i!=0){
				hql+=" and member_id ='"+i+"'";
			}
			if(start!=null&&!"".equals(start)){
	       		 hql+=" and create_date like '%"+start+"%'";
	       	 }
			if(type!=null&&!"".equals(type)){
				hql+=" and trade_type ='"+type+"'";
			}
			if(zhifu!=null&&!"".equals(zhifu)){
				hql+=" and ext_field_3 = '"+zhifu+"'";
			}
			System.out.println(hql);
		List<MemberTradeRecord> list=session.createQuery(hql).list();
		System.out.println(list.size()+"qwee");
		return list;
	}

	public List<MemberAccount> lsma(String iphone,String start) {
		Session session=getSession();
		System.out.println("aaaa");
		String hql=" from MemberAccount ";
		 List<Member> m=lsm(iphone);
			int i=m.get(0).getId();
			if(i!=0){
				hql+=" where  member_id ='"+i+"'";
			}
			if(start!=null&&!"".equals(start)){
	       		 hql+=" and create_date like '%"+start+"%'";
	       	 }
			System.out.println(hql);
		List<MemberAccount> list=session.createQuery(hql).list();
		System.out.println(list.size()+"123132131");
		return list;
	}
	public boolean tf(String title) {
		System.out.println(title);
		Session session=getSession();
		String hql=" from Member where mobile_Phone='"+title+"'";
		List list=session.createQuery(hql).list();
		System.out.println(hql);
		if(list.size()>0){
			return true;
		}else{
		return false;
	}
	}

}
