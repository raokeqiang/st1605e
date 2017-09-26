package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.Member;
import com.profit.dao.RoleDao;
import com.profit.daoimpl.MemberDaoImpl;
import com.profit.service.RoleService;

@Service
@Transactional

public class MemderServiceImpl implements RoleService<Member>{

	@Autowired
	private MemberDaoImpl memberDaoImpl;
	
	//查询账户
	@Override
	public List<Member> listMemder(){
		return memberDaoImpl.listMemder();
	}

	@Override
	public void updateUsers(String password, String user_name) {
		// TODO Auto-generated method stub
		
	}
}
