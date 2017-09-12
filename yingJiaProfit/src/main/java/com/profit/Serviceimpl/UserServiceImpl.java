package com.profit.Serviceimpl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Users;
import com.profit.daoimpl.UserDaoImpl;
import com.profit.service.UserService;

@Component
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Override
	public List<Users> ListAll(Object... objects) {
		List<Users> User = userDaoImpl.ListAll();
		return User;
	}

	@Override
	public Users getByName(String name) {
		Users users = userDaoImpl.getByName(name);
		return users;
	}
	@Override
	public void save(Object... object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public void update(Object object) {
		// TODO Auto-generated method stub

	}

	@Override
	public <T> T getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> ListAlltrue(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<String> ListAllByName(Object object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> Set<String> ListResourcesByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
