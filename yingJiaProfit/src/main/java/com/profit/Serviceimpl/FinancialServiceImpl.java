package com.profit.Serviceimpl;
import java.util.List;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.dao.FinancialDao;
import com.profit.service.FinancialService;
@Service
public class FinancialServiceImpl implements FinancialService{

	@Autowired
	@Qualifier("financialDaoImpl")
	private FinancialDao financialDaoImpl;

	public List<AwardRecords> lsa(String iphone,String start) {
		return financialDaoImpl.lsa(iphone, start);
	}

	public List<Member> lsm(String iphone) {
		return financialDaoImpl.lsm(iphone);
	}
//
	public List<MemberDepositRecord> lsmdr(String iphone,String start) {
		return financialDaoImpl.lsmdr(iphone, start);
	}

	public List<Member_tally> lsmt(String iphone,String start) {
		return financialDaoImpl.lsmt(iphone, start );
	}

	public List<MembeWithdrawRecord> lsmw(String iphone,String start) {
		return financialDaoImpl.lsmw(iphone, start);
	}

	public List<MemberTradeRecord> lst(String iphone,String start,String type,String zhifu) {
		return financialDaoImpl.lst(iphone, start,type,zhifu);
	}

	public List<MemberAccount> lsma(String iphone,String start) {
		return financialDaoImpl.lsma(iphone, start);
	}
	public boolean tf(String title) {
		return financialDaoImpl.equals(title);
	}
}
