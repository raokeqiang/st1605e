package com.profit.Serviceimpl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.UserRole;
import com.profit.dao.UserRoleImpl;
import com.profit.service.UserService;

@Component
@Transactional
public class UserRoleServiceImpl implements UserService {
	@Autowired
	private UserRoleImpl userRoleImpl;

	@Override
	public List<UserRole> ListAll(Object... object) {
		List<UserRole> UserRoleList = userRoleImpl.ListAll();
		return UserRoleList;
	}

	@Override
	public List ListAlltrue(int id) {
		List UserRoleList = userRoleImpl.ListAlltrue(id);
		return UserRoleList;
	}

	@Override
	public void save(Object... object) {
		userRoleImpl.SaveRole(object);

	}

	

	@Override
	public void update(Object object) {
		userRoleImpl.UpdateRole(object);

	}

	@Override
	public UserRole getById(int id) {
		UserRole userRole = userRoleImpl.ListAllById(id);
		return userRole;
	}

	@Override
	public Set<String> ListAllByName(Object object) {
		Set<String> set = userRoleImpl.ListAllByName(object);
		return set;
	}

	@Override
	public <T> Set<String> ListResourcesByName(String name) {
		Set<String> set = userRoleImpl.ListResourcesByName(name);
		return set;
	}

	@Override
	public Boolean getByName(String name) {
		boolean boo = userRoleImpl.getByName(name);
		return boo;
	}

	@Override
	public void delete(Object object) {
		// TODO Auto-generated method stub

	}
}
