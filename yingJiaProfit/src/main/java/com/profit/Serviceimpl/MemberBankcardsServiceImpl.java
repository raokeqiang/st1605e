package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberBankcards;
import com.profit.daoimpl.MemberBankcardsDao;
import com.profit.service.BackwService;

@Component
public class MemberBankcardsServiceImpl implements BackwService<MemberBankcards>{
	
 @Autowired
  private MemberBankcardsDao memberBankcardsDao;
	
@Override
public void save(MemberBankcards obj) {
	// TODO Auto-generated method stub
	
}

@Override
public void delete(MemberBankcards obj) {
	// TODO Auto-generated method stub
	
}

@Override
public void update(MemberBankcards obj) {
	memberBankcardsDao.update(obj);
}

@Override
public List<MemberBankcards> listAll(Map map) {
	return memberBankcardsDao.ListAll(map);
}

@Override
public MemberBankcards getById(int id) {
	return memberBankcardsDao.getById(id);
}
}

