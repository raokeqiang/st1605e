package com.profit.dao;

import java.util.List;

import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberProfitRecord;
import com.profit.bean.MemberPucChargeItem;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SysRechargePriceConfig;

public interface ShoppingListDao {
 
	List<SysRechargePriceConfig> listRechargePriceConfig();//充值面额管理
	List<Member_tally> listSysMember_tally();//用户消费记录
	List<MembeWithdrawRecord> listMembeWithdrawRecord();//提现记录
	List<MemberAccount> listMemberAccount();//用户统计
	List<AwardRecords> listAwardRecords();//奖励记录
	List<MemberPucChargeItem> listMemberPucChargeItem();//缴费项目
	List<Member> listMember(String iopne);//用户交易记录
	List<Subject> listSubject();//投资的详细信息
	List<MemberDepositRecord> listMemberDepositRecord();//充值记录
	List<MemberProfitRecord> listMemberProfitRecord();//收益记录
}
