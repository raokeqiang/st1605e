package com.profit.Serviceimpl;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Member;
import com.profit.daoimpl.FrontLoginDaoImpl;
import com.profit.service.FrontLoginService;

@Component
@Transactional
public class FrontLoginServiceImpl implements FrontLoginService{
	
	@Autowired
	private FrontLoginDaoImpl frontLoginDaoImpl;

	@Override
	public boolean checkLogin(String mobelPhone, String password) {
		return this.frontLoginDaoImpl.checkUserLogin(mobelPhone, password);
	}

	@Override
	public Member getMemberByPhone(String mobelPhone) {
		return this.frontLoginDaoImpl.getMemberByPhone(mobelPhone);
	}

	@Override
	public void saveMember(Member member) {
		this.frontLoginDaoImpl.saveMember(member);;
	}

}
