package com.profit.service;

import java.util.List;

import com.profit.bean.Member;
import com.profit.bean.MemberBankcards;
import com.profit.bean.SysRegion;

public interface FrontJiLianService {
	public List<SysRegion> getSheng();
	public List<SysRegion> getShi(int pid);
	public List<SysRegion> getxiang(int sid);
	public String getmin(int id);
	public void saveka(MemberBankcards mb);
	public List selectka(String idcard);
	public List bankCarkcheck(String bankCark);
	public void updateka(Member member);
}
