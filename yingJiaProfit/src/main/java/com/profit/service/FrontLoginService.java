package com.profit.service;

import com.profit.bean.Member;

public interface FrontLoginService {
	
	public boolean checkLogin(String mobelPhone,String password);
	
	public Member getMemberByPhone(String mobelPhone);

}
