package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.Member;
import com.profit.bean.UserRole;
import com.profit.dao.RoleDao;
import com.profit.service.RoleService;

@Service
@Transactional
public class RoleServiceImpl implements RoleService<UserRole> {
	
	@Autowired
	@Qualifier("roleDaoImpl")
	private RoleDao<UserRole> roleDaoImpl;
	

	//查询角色
	public List<UserRole> listRole(){
		return roleDaoImpl.listRole();
	}
	//查询账户
	@Override
	public List<UserRole> listMemder() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
