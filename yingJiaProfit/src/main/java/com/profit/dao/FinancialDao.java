 package com.profit.dao;

import java.util.List;

import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;

public interface FinancialDao {

	List<AwardRecords> lsa(String iphone,String start);//奖励记录表
	List<Member> lsm(String iphone);//用户信息表
	List<MemberDepositRecord > lsmdr(String iphone,String start);//充值记录表
	List<Member_tally> lsmt(String iphone,String start);//生活消费
	List<MembeWithdrawRecord  > lsmw(String iphone,String start); //提现记录
	List<MemberTradeRecord > lst(String iphone,String start,String type,String zhifu);//交易记录
	List<MemberAccount   > lsma(String iphone,String start);//余额表
	boolean tf(String title);
}
