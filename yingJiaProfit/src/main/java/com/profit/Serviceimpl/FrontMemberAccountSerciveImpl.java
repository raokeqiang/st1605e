package com.profit.Serviceimpl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberAccount;
import com.profit.daoimpl.FrontMemberAccountDaoImpl;
import com.profit.service.FrontMemberAccountService;

@Component
@Transactional
public class FrontMemberAccountSerciveImpl implements FrontMemberAccountService{

	@Autowired
	private FrontMemberAccountDaoImpl frontMemberAccountDaoImpl;

	@Override
	public MemberAccount selectMA(int member_id) {
		return this.frontMemberAccountDaoImpl.selectMA(member_id);
	}
	
	
}
