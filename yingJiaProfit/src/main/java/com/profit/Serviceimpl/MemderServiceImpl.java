package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.Member;
import com.profit.dao.RoleDao;
import com.profit.service.RoleService;

@Service
@Transactional

public class MemderServiceImpl implements RoleService<Member>{

	@Autowired
	@Qualifier("memberDaoImpl")
	private RoleDao<Member> memberDaoImpl;
	
	//查询角色
	@Override
	public List<Member> listRole() {
		// TODO Auto-generated method stub
		return null;
	}
	//查询账户
	@Override
	public List<Member> listMemder(){
		return memberDaoImpl.listMemder();
	}

}
