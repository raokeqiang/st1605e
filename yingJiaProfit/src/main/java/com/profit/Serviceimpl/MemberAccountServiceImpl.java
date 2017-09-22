package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberAccount;
import com.profit.daoimpl.MemberAccountDao;
import com.profit.service.BackwService;

@Component
public class MemberAccountServiceImpl  implements BackwService<MemberAccount>{
	
	@Autowired
	private MemberAccountDao memberAccountDao;

	@Override
	public void save(MemberAccount obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberAccount obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberAccount obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberAccount> listAll(Map map) {
		return memberAccountDao.ListAll(map);
	}

	@Override
	public MemberAccount getById(int id) {
		return memberAccountDao.getById(id);
	}

}
