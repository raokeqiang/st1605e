package com.profit.daoimpl;

import java.util.ArrayList;
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
import com.profit.bean.MemberProfitRecord;
import com.profit.bean.MemberPucChargeItem;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SysRechargePriceConfig;
import com.profit.dao.ShoppingListDao;
@Component
public class ShoppingListDaoImpl implements ShoppingListDao{
	@Autowired
	private SessionFactory sessionFactory;
	
	 public Session getSession(){
		 return sessionFactory.getCurrentSession();
	  }
	 public List<SysRechargePriceConfig> listRechargePriceConfig() {
		Session session=getSession();
		String sql="select type,SUM(market_price) market_price from sys_recharge_price_config  group by type";
		List list=session.createSQLQuery(sql).list();
		List<SysRechargePriceConfig> listsys=new ArrayList<SysRechargePriceConfig>();
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[])list.get(i);
			SysRechargePriceConfig sysRechargePriceConfig=new SysRechargePriceConfig();
			sysRechargePriceConfig.setType(obj[0].toString());
			sysRechargePriceConfig.setMarket_price((int)Float.parseFloat(obj[1].toString()));
			listsys.add(sysRechargePriceConfig);
		}
		return listsys;
	}

	public List<Member_tally> listSysMember_tally() {
		Session session=getSession();
		String hql=" from Member_tally" ;
		List<Member_tally> list=session.createQuery(hql).list();
		return list;
	}

	public List<MembeWithdrawRecord> listMembeWithdrawRecord() {
		Session session=getSession();
		String sql="select channel_name,SUM(amount) FROM member_withdraw_record group by channel_name";
		List list=session.createSQLQuery(sql).list();
		List<MembeWithdrawRecord> listmem=new ArrayList<MembeWithdrawRecord>();
		for(int i=0;i<list.size();i++){
			Object[] obj=(Object[])list.get(i);
			MembeWithdrawRecord membeWithdrawRecord=new MembeWithdrawRecord();
			membeWithdrawRecord.setChannel_name(obj[0].toString());
			membeWithdrawRecord.setAmount((int)Float.parseFloat(obj[1].toString()));
			listmem.add(membeWithdrawRecord);
			}
		return listmem;
	}

	public List<MemberAccount> listMemberAccount() {
		Session session=getSession();
		String hql=" from MemberAccount";
		List<MemberAccount> list=session.createQuery(hql).list();
		return list;
	}

	public List<AwardRecords> listAwardRecords() {
		Session session=getSession();
		String hql=" from AwardRecords";
		List<AwardRecords> list=session.createQuery(hql).list();
		return list;
	}

	public List<MemberPucChargeItem> listMemberPucChargeItem() {
		Session session=getSession();
		String hql=" from MemberPucChargeItem";
		List<MemberPucChargeItem> list=session.createQuery(hql).list();
		return list;
	}

	public List<Member> listMember(String iopne) {
		Session session=getSession();
		String hql=" from Member where 0=0";
		if(iopne!=null&&!"".equals(iopne)){
			hql+=" and mobile_Phone like '"+iopne+"'" ;
		}
		List<Member> list=session.createQuery(hql).list();
		return list;
	}

	public List<Subject> listSubject() {
		Session session=getSession();
		String hql=" from Subject";
		List<Subject> list=session.createQuery(hql).list();
		return list;
	}

	public List<MemberDepositRecord> listMemberDepositRecord() {
		Session session=getSession();
		String hql=" from MemberDepositRecord";
		List<MemberDepositRecord> list=session.createQuery(hql).list();
		return list;
	}

	public List<MemberProfitRecord> listMemberProfitRecord() {
		Session session=getSession();
		String hql=" from MemberProfitRecord";
		List<MemberProfitRecord> list=session.createQuery(hql).list();
		return list;
	}

	
}
