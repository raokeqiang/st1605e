package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
