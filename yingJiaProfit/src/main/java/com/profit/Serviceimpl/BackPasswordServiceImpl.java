package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profit.bean.Users;
import com.profit.daoimpl.BackPasswordDaoImpl;
import com.profit.service.RoleService;

@Service
@Transactional
public class BackPasswordServiceImpl implements RoleService<Users> {
	
	@Autowired
	private BackPasswordDaoImpl backPasswordDaoImpl;
	
	@Override
	public List<Users> listMemder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateUsers(String password, String user_name) {
	 this.backPasswordDaoImpl.updateUsers(password, user_name);
		
	}
	
	

}
