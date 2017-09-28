package com.profit.Serviceimpl;

import java.util.List;

import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberTradeRecord;
import com.profit.dao.MemberTradeRecordDao;
import com.profit.service.MemberTradeRecordService;
@Transactional
@Component
public class MemberTradeRecordWalletServiceImpl implements MemberTradeRecordService{

	@Autowired
	@Qualifier("memberTradeRecordDaoImpl")
	private MemberTradeRecordDao memberTradeRecordDaoImpl;

	public List<MemberTradeRecord> listAll(Map map) {
		return memberTradeRecordDaoImpl.listAll(map);
	}

	public String listhql(Map map, String hql) {
		return memberTradeRecordDaoImpl.listhql(map, hql);
	}
	

}
