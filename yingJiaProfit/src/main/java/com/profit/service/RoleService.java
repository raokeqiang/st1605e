package com.profit.service;

import java.util.List;


public interface RoleService<T> {
	 List<T> listMemder();
	 public void updateUsers(String password,String user_name);
}
