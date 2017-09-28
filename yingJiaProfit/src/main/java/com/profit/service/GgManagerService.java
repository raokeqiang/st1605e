package com.profit.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SysRechargePriceConfig;
@Service
@Transactional
public interface GgManagerService {

	//红包统计
	public List<AwardRecords> ListCop(String creatTime,String vs,String month);

	public List<AwardRecords> ListCop1(String creatTime,String vs,String month);

	public List<Subject> ListCop2(String creatTime,String endTime,String vs,String month);

	public List<Subject> ListCop3(String creatTime,String endTime,String vs,String month);
	
	public List<Subject> ListCop4(String creatTime,String endTime,String vs,String month);
	public List<SysRechargePriceConfig> ListCop5(String creatTime,String vs,String month);

	public List<SysRechargePriceConfig> ListCop6(String creatTime,String vs,String month);

	public List<MembeWithdrawRecord> ListCop7(String creatTime,String vs,String month);

	public List<MembeWithdrawRecord> ListCop8(String creatTime,String vs,String month);

	public List<Subject> ListCop9(String creatTime,String endTime,String vs,String month);

	public List<Subject> ListCop10(String creatTime,String endTime,String vs,String month);

	public List<Subject> ListCop11(String creatTime,String endTime,String vs,String month);

	public List<MemberTradeRecord> ListCop12(String creatTime,String vs,String month);

	public List<MemberTradeRecord> ListCop13(String creatTime,String vs,String month);

	public List<Member_tally> ListCop14(String creatTime,String vs,String month);
}
