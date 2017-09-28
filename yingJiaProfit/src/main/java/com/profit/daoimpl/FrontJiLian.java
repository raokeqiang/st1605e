package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Member;
import com.profit.bean.MemberBankcards;
import com.profit.bean.SysRegion;

@Component
public class FrontJiLian {
	@Autowired
	public SessionFactory sessionFactory;
	
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}
	
	//获取省
	public List<SysRegion> getSheng() {
		// TODO Auto-generated method stub
		String sql="from SysRegion where region_level=1";
		return getSession().createQuery(sql).list();
	}
	//获取市
	
	public List<SysRegion> getShi(int pid) {
		// TODO Auto-generated method stub
		String sql="from SysRegion where region_level=2 and parent_id = "+pid+"";
		return getSession().createQuery(sql).list();
	}
	
	//获取县
	public List<SysRegion> getxiang(int sid) {
		// TODO Auto-generated method stub
		String sql="from SysRegion where region_level=3 and parent_id = "+sid+"";
		return getSession().createQuery(sql).list();
	}
	//查询名称
	public String getmin(int id){
		String sql="select name from sys_region where region_level="+id;
		List list=getSession().createSQLQuery(sql).list();
		return (String) list.get(0);
	}
	//绑定卡号
	public void saveka(MemberBankcards mb){
		getSession().save(mb);
	}
	public List selectka(String idcard){
		String sql="from Member where identity="+idcard;
		return getSession().createQuery(sql).list();
	}
	public List bankCarkcheck(String bankCark){
		String sql="from MemberBankcards where card_no="+bankCark;
		return getSession().createQuery(sql).list();
	}
	public void updateka(Member member){
		getSession().update(member);
	}
	
}
