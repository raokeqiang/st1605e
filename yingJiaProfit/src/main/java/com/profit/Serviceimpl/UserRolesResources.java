package com.profit.Serviceimpl;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Resources;
import com.profit.daoimpl.UserRolesResourcesDaoImpl;
import com.profit.service.UserService;
@Component
@Transactional
public class UserRolesResources implements UserService{

	@Autowired
	private UserRolesResourcesDaoImpl userRolesResourcesDaoImpl;

	@Override
	public List<Resources> ListAll(Object...objects) {
		List<Resources> UserResources=userRolesResourcesDaoImpl.ListAll();
		return UserResources;
	}
	
	@Override
	public void save(Object...objects) {
		userRolesResourcesDaoImpl.save(objects);
		
	}
	
	@Override
	public  List<Resources> getById(int id) {
		List<Resources> resources=userRolesResourcesDaoImpl.ListById(id);
		return resources;
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
	public <T> T getByName(String name) {
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
