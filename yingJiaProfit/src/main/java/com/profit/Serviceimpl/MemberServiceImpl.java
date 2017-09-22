package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.profit.bean.Member;
import com.profit.daoimpl.MemberDao;
import com.profit.service.BackwService;

@Component
public class MemberServiceImpl implements BackwService<Member>{

	@Autowired
	private MemberDao memberDao;

	@Override
	public void save(Member obj) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(Member obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Member obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Member> listAll(Map map) {
		return memberDao.ListAll(map);
	}

	@Override
	public Member getById(int id) {
		return memberDao.getById(id);
	}
	
	
}
