package com.profit.dao;

import java.util.List;

import com.profit.bean.UserRole;

public interface RoleDao<T> {
	
	List<T> listRole();
	List<T> listMemder();
	
}
