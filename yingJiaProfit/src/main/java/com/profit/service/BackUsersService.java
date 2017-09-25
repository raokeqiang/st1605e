package com.profit.service;

import java.util.List;

import com.profit.bean.UserRole;
import com.profit.bean.Users;

public interface BackUsersService {
	public List ListUser();
	public List rlistUser();
	public void saveUsers(Users users);
	public UserRole selectRo(int rid);

}
