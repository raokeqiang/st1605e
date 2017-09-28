package com.profit.service;

import java.util.List;


public interface RoleService<T> {
	 List<T> listMemder();
	 public void updateUsers(String password,String user_name);
	 public void updateUsers1(String password2,String password1);
}
