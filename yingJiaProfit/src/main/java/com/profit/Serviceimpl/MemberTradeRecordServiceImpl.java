package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberTradeRecord;
import com.profit.daoimpl.MemberTradeRecordDao;
import com.profit.service.BackwService;

@Component
public class MemberTradeRecordServiceImpl implements BackwService<MemberTradeRecord> {

	@Autowired
	private MemberTradeRecordDao memberTradeRecordDao;

	@Override
	public void save(MemberTradeRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MemberTradeRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MemberTradeRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<MemberTradeRecord> listAll(Map map) {
		return memberTradeRecordDao.ListAll(map);
	}

	@Override
	public MemberTradeRecord getById(int id) {
		return memberTradeRecordDao.getById(id);
	}
}
