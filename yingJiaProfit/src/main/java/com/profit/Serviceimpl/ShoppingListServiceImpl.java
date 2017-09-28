package com.profit.Serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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
import com.profit.service.ShoppingListService;
@Component
public class ShoppingListServiceImpl implements ShoppingListService{
	@Autowired
	@Qualifier("shoppingListDaoImpl")
	private ShoppingListDao shoppingListDaoImpl;

	public List<SysRechargePriceConfig> listRechargePriceConfig() {
		return shoppingListDaoImpl.listRechargePriceConfig();
	}

	public List<Member_tally> listMember_tally() {
		return shoppingListDaoImpl.listSysMember_tally();
	}

	public List<MembeWithdrawRecord> listMembeWithdrawRecord() {
		return shoppingListDaoImpl.listMembeWithdrawRecord();
	}

	public List<MemberAccount> listMemberAccount() {
		return shoppingListDaoImpl.listMemberAccount();
	}

	public List<AwardRecords> listAwardRecords() {
		return shoppingListDaoImpl.listAwardRecords();
	}

	public List<MemberPucChargeItem> listMemberPucChargeItem() {
		return shoppingListDaoImpl.listMemberPucChargeItem();
	}

	public List<Member> listMember(String iopne) {
		return shoppingListDaoImpl.listMember(iopne);
	}

	public List<Subject> listSubject() {
		return shoppingListDaoImpl.listSubject();
	}

	public List<MemberDepositRecord> listMemberDepositRecord() {
		return shoppingListDaoImpl.listMemberDepositRecord();
	}

	public List<MemberProfitRecord> listMemberProfitRecord() {
		return shoppingListDaoImpl.listMemberProfitRecord();
	}

	
}
