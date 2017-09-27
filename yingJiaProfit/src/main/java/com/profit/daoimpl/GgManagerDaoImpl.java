package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SysRechargePriceConfig;
import com.profit.dao.GgManagerDao;

@Component
public class GgManagerDaoImpl implements GgManagerDao  {

	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession(){
		return this.sessionFactory.getCurrentSession();
	}
		//红包统计
         public List<AwardRecords> ListCop(String creatTime,String vs,String month) {
        	 Session session = getSession();
     		String hql="select sum(amount) from award_records where type=0 and isAward=1";
     		if(creatTime!=null&&!"".equals(creatTime)){
        		 hql+=" and addTime like '%"+creatTime+"%'";
        	 }
     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
     			hql+=" and addTime >='"+vs+"'";
     			hql+=" and addTime <'"+month+"'";
     		}
     		System.out.println(hql);
     		 List list =session.createSQLQuery(hql).list();
     		return list;
}
       //红包统计
		public List<AwardRecords> ListCop1(String creatTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(amount) from award_records where type=1 and isAward=1";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and addTime like '%"+creatTime+"%'";
	        	 }
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and addTime >='"+vs+"'";
	     			hql+=" and addTime <'"+month+"'";
	     		}
	     		 List list2 =session.createSQLQuery(hql).list();
	     		return list2;
		}
		//收益统计
		public List<Subject> ListCop2(String creatTime,String endTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(amount) from Subject where type=0 ";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and start_date like '%"+creatTime+"%'";
	        	 }
	     		if(endTime!=null&&!"".equals(endTime)){
	        		 hql+=" and end_date like '%"+endTime+"%'";
	        	 }
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and start_date >='"+vs+"'";
	     			hql+=" and start_date <'"+month+"'";
	     		}
	     		 List list3 =session.createSQLQuery(hql).list();
	     		return list3;
		}
		//收益统计
		public List<Subject> ListCop3(String creatTime,String endTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(amount) from Subject where type=1 ";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and start_date like '%"+creatTime+"%'";
	        	 }
	     		if(endTime!=null&&!"".equals(endTime)){
	        		 hql+=" and end_date like '%"+endTime+"%'";
	        	 }
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and start_date >='"+vs+"'";
	     			hql+=" and start_date <'"+month+"'";
	     		}
	     		 List list4 =session.createSQLQuery(hql).list();
	     		return list4;
		}
		//收益统计
		public List<Subject> ListCop4(String creatTime,String endTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(amount) from Subject where type=2 ";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and start_date like '%"+creatTime+"%'";
	        	 }
	     		if(endTime!=null&&!"".equals(endTime)){
	        		 hql+=" and end_date like '%"+endTime+"%'";
	        	 }
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and start_date >='"+vs+"'";
	     			hql+=" and start_date <'"+month+"'";
	     		}
	     		 List list5 =session.createSQLQuery(hql).list();
	     		return list5;
		}
		public List<SysRechargePriceConfig> ListCop5(String creatTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(market_price) from Sys_recharge_price_config where type='MOBILE' ";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and create_date like '%"+creatTime+"%'";
	        	 }
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and create_date >='"+vs+"'";
	     			hql+=" and create_date <'"+month+"'";
	     		}
	     		 List list6 =session.createSQLQuery(hql).list();
	     		return list6;
		}
		@Override
		public List<SysRechargePriceConfig> ListCop6(String creatTime,String vs,String month) {
			Session session = getSession();
     		String hql="select sum(market_price) from Sys_recharge_price_config where type='OIL' ";
     		if(creatTime!=null&&!"".equals(creatTime)){
       		 hql+=" and create_date like '%"+creatTime+"%'";
       	 }
     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
     			hql+=" and create_date >='"+vs+"'";
     			hql+=" and create_date <'"+month+"'";
     		}
     		 List list7 =session.createSQLQuery(hql).list();
     		return list7;
		}
		@Override
		public List<MembeWithdrawRecord> ListCop7(String creatTime,String vs,String month) {
			Session session = getSession();
     		String hql="select sum(amount) from Member_withdraw_record where channel_name='FUIOU' ";
     		if(creatTime!=null&&!"".equals(creatTime)){
          		 hql+=" and create_date like '%"+creatTime+"%'";
          	 }
     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
     			hql+=" and create_date >='"+vs+"'";
     			hql+=" and create_date <'"+month+"'";
     		}
     		 List list8 =session.createSQLQuery(hql).list();
     		return list8;
		}
		@Override
		public List<MembeWithdrawRecord> ListCop8(String creatTime,String vs,String month) {
			Session session = getSession();
     		String hql="select sum(amount) from Member_withdraw_record where channel_name='BEIFU' ";
     		if(creatTime!=null&&!"".equals(creatTime)){
         		 hql+=" and create_date like '%"+creatTime+"%'";
         	 }
     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
     			hql+=" and create_date >='"+vs+"'";
     			hql+=" and create_date <'"+month+"'";
     		}
     		 List list9 =session.createSQLQuery(hql).list();
     		return list9;
		}
		@Override
		public List<Subject> ListCop9(String creatTime,String endTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(floor_amount) from Subject where type=0 ";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and start_date like '%"+creatTime+"%'";
	        	 }
	     		if(endTime!=null&&!"".equals(endTime)){
	        		 hql+=" and end_date like '%"+endTime+"%'";
	        	 }
	     		
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and start_date >='"+vs+"'";
	     			hql+=" and start_date <'"+month+"'";
	     		}
	     		 List list10 =session.createSQLQuery(hql).list();
	     		return list10;
		}
		@Override
		public List<Subject> ListCop10(String creatTime,String endTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(floor_amount) from Subject where type=1 ";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and start_date like '%"+creatTime+"%'";
	        	 }
	     		if(endTime!=null&&!"".equals(endTime)){
	        		 hql+=" and end_date like '%"+endTime+"%'";
	        	 }
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and start_date >='"+vs+"'";
	     			hql+=" and start_date <'"+month+"'";
	     		}
	     		 List list11 =session.createSQLQuery(hql).list();
	     		return list11;
		}
		@Override
		public List<Subject> ListCop11(String creatTime,String endTime,String vs,String month) {
			 Session session = getSession();
	     		String hql="select sum(floor_amount) from Subject where type=2 ";
	     		if(creatTime!=null&&!"".equals(creatTime)){
	        		 hql+=" and start_date like '%"+creatTime+"%'";
	        	 }
	     		if(endTime!=null&&!"".equals(endTime)){
	        		 hql+=" and end_date like '%"+endTime+"%'";
	        	 }
	     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
	     			hql+=" and start_date >='"+vs+"'";
	     			hql+=" and start_date <'"+month+"'";
	     		}
	     		 List list12 =session.createSQLQuery(hql).list();
	     		return list12;
		}
		@Override
		public List<MemberTradeRecord> ListCop12(String creatTime,String vs,String month) {
			Session session = getSession();
     		String hql="select sum(amount) from member_trade_record where trade_name LIKE '%手机充值%'";
     		if(creatTime!=null&&!"".equals(creatTime)){
       		 hql+=" and create_date like '%"+creatTime+"%'";
       	 }
     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
     			hql+=" and create_date >='"+vs+"'";
     			hql+=" and create_date <'"+month+"'";
     		}
     		 List list13 =session.createSQLQuery(hql).list();
     		return list13;
		}
		@Override
		public List<MemberTradeRecord> ListCop13(String creatTime,String vs,String month) {
			Session session = getSession();
     		String hql="select sum(amount) from member_trade_record where trade_name LIKE '%石化卡充值 %'";
     		if(creatTime!=null&&!"".equals(creatTime)){
          		 hql+=" and create_date like '%"+creatTime+"%'";
          	 }
     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
     			hql+=" and create_date >='"+vs+"'";
     			hql+=" and create_date <'"+month+"'";
     		}
     		 List list14 =session.createSQLQuery(hql).list();
     		return list14;
		}
		@Override
		public List<Member_tally> ListCop14(String creatTime,String vs,String month) {
			Session session = getSession();
     		String hql="select sum(amount) from member_tally where 0=0";
     		if(creatTime!=null&&!"".equals(creatTime)){
         		 hql+=" and create_date like '%"+creatTime+"%'";
         	 }
     		if(month!=null&&!"".equals(month)&&vs!=null&&!"".equals(vs)){
     			hql+=" and create_date >='"+vs+"'";
     			hql+=" and create_date < '"+month+"'";
     		}
     		 List list15 =session.createSQLQuery(hql).list();
     		return list15;
		}
		}
