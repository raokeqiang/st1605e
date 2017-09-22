package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.MemberAccount;
import com.profit.daoimpl.MembeWithdrawRecordDao;
import com.profit.service.BackwService;

@Component
public class MemberWithdrawRecordServiceImpl implements BackwService<MembeWithdrawRecord>{

	@Autowired
	private MembeWithdrawRecordDao membeWithdrawRecordDao;

	@Override
	public void save(MembeWithdrawRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(MembeWithdrawRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MembeWithdrawRecord obj) {
		membeWithdrawRecordDao.update(obj);
	}

	@Override
	public List<MembeWithdrawRecord> listAll(Map map) {
		return membeWithdrawRecordDao.ListAll(map);
	}

	@Override
	public MembeWithdrawRecord getById(int id) {
	 MembeWithdrawRecord membeWithdrawRecord=membeWithdrawRecordDao.getById(id);
		return membeWithdrawRecord;
	}
	
}
