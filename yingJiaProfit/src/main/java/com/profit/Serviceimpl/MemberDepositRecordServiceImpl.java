package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberDepositRecord;
import com.profit.daoimpl.MemberDepositRecordDao;
import com.profit.service.BackwService;

@Component
public class MemberDepositRecordServiceImpl implements BackwService<MemberDepositRecord>{

	@Autowired
	private MemberDepositRecordDao memberDepositRecordDao;
	
	@Override
	public void save(MemberDepositRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberDepositRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberDepositRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberDepositRecord> listAll(Map map) {
		// TODO Auto-generated method stub
		return memberDepositRecordDao.ListAll(map);
	}

	@Override
	public MemberDepositRecord getById(int id) {
		return memberDepositRecordDao.getById(id);
	}

}
