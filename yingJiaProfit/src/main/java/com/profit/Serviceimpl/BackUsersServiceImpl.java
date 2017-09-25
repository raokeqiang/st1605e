package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profit.bean.UserRole;
import com.profit.bean.Users;
import com.profit.daoimpl.BkUsersDaoImpl;
import com.profit.service.BackUsersService;

@Service
@Transactional
public class BackUsersServiceImpl implements BackUsersService {
	
	@Autowired
	private BkUsersDaoImpl bkUsersDaoImpl;

	@Override
	public List ListUser() {
		return this.bkUsersDaoImpl.ListUser();
	}

	@Override
	public List rlistUser() {
		return this.bkUsersDaoImpl.listRole();
	}

	@Override
	public void saveUsers(Users users) {
		this.bkUsersDaoImpl.saveUsers(users);
		
	}

	@Override
	public UserRole selectRo(int rid) {
		return  this.bkUsersDaoImpl.selectRo(rid);
	}
}
