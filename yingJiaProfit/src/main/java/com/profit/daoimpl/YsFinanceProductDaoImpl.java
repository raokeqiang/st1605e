package com.profit.daoimpl;

import java.util.List;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.FinanceProductFunds;
import com.profit.bean.FinanceProductSubscribe;
import com.profit.dao.YsFinanceProductDao;
@Component
public class YsFinanceProductDaoImpl implements YsFinanceProductDao{
	@Autowired
	public SessionFactory sessionFactory;
	@Override
	public List<FinanceProductFunds> showmoney(Map map) {
		String hql="from FinanceProductFunds where 0=0";
		hql=listDataHql(hql, map);
		System.out.println(hql);
		Session session=getSession();
		List<FinanceProductFunds>list=session.createQuery(hql).list();
		return list;
}

	@Override
	public void addmoney(FinanceProductFunds finance) {
		  Session  session=getSession();
		  session.save(finance);
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public String listDataHql(String hql, Map map) {
		String name=(String)map.get("name");
		String type=(String)map.get("type");
		String status=(String)map.get("status");
		if(name!=null&&!name.equals("")){
			hql+=" and name like '%"+name+"%'";
		}
		if(type!=null&&!type.equals("")){
			hql+=" and type like '%"+type+"%'";
		}
		if(status!=null&&!status.equals("")){
			hql+=" and status like '%"+status+"%'";
		}
	return hql;
		
	}

	@Override
	public void update(FinanceProductFunds finance) {
  Session session=getSession();
  session.update(finance);
	}

	@Override
	public FinanceProductFunds getById(int id) {
		FinanceProductFunds finance=(FinanceProductFunds)this.getSession().get(FinanceProductFunds.class, id);
		return finance;
	}
	//显示签署状态
	@Override
	public List<FinanceProductSubscribe> showmoneyding(int id) {
		String hql="from FinanceProductSubscribe where product_id= " +id;
		Session session=getSession();
		List<FinanceProductSubscribe>list=session.createQuery(hql).list();
		return list;
	}

	@Override
	public FinanceProductSubscribe getByIding(int id) {
		FinanceProductSubscribe finance=(FinanceProductSubscribe)this.getSession().get(FinanceProductSubscribe.class, id);
		return finance;
	}

	@Override
	public void updatehe(FinanceProductSubscribe fina) {
  Session session=getSession();
  session.update(fina);
	}

	

}
