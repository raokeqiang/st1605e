package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Member;
import com.profit.bean.MemberBankcards;
import com.profit.bean.SysRegion;
import com.profit.daoimpl.FrontJiLian;
import com.profit.service.FrontJiLianService;

@Component
@Transactional
public class FrontJiLianServiceImpl implements FrontJiLianService{
	
	@Autowired
	private FrontJiLian frontJiLian;
	
	@Override
	public List<SysRegion> getSheng() {
		return this.frontJiLian.getSheng();
	}

	@Override
	public List<SysRegion> getShi(int pid) {
		// TODO Auto-generated method stub
		return this.frontJiLian.getShi(pid);
	}

	@Override
	public List<SysRegion> getxiang(int sid) {
		// TODO Auto-generated method stub
		return this.frontJiLian.getxiang(sid);
	}

	@Override
	public String getmin(int id) {
		return this.frontJiLian.getmin(id);
	}

	@Override
	public void saveka(MemberBankcards mb) {
		this.frontJiLian.saveka(mb);		
	}

	@Override
	public List selectka(String idcard) {
		return this.frontJiLian.selectka(idcard);
	}

	@Override
	public List bankCarkcheck(String bankCark) {
		return this.frontJiLian.bankCarkcheck(bankCark);
	}

	@Override
	public void updateka(Member member) {
		this.frontJiLian.updateka(member);
	}



}
