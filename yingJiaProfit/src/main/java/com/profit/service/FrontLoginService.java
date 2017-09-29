package com.profit.service;

import com.profit.bean.Member;
import com.profit.bean.MemberBankcards;

public interface FrontLoginService {
	
	public boolean checkLogin(String mobelPhone,String password);
	
	public Member getMemberByPhone(String mobelPhone);
	public void saveMember(Member member);
	public MemberBankcards getMemberBankcards(int member_id);
	public void updatepwd(Member member);

}
