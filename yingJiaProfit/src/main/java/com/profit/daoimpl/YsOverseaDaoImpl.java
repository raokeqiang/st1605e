package com.profit.daoimpl;

import java.util.List;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.MemberBankcards;
import com.profit.bean.OverseaConfig;
import com.profit.bean.OverseaConfigSubscribe;
import com.profit.dao.YsOverseaConfigDao;
@Component
public class YsOverseaDaoImpl implements YsOverseaConfigDao {
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public List<OverseaConfig> listAllover() {
		  Session session=getSession();
		  List<OverseaConfig> list=session.createQuery("from OverseaConfig").list();
		  return list;
	}

	@Override
	public List<OverseaConfigSubscribe> listover(int id) {
		 Session session=getSession();
		 String hql="from OverseaConfigSubscribe  where id ="+id;
		  List<OverseaConfigSubscribe> list2=session.createQuery(hql).list();
		  return list2;
	}

	@Override
	public OverseaConfig getoverById(int id) {
		 Session session=getSession();
		  OverseaConfig  over =(OverseaConfig)session.get(OverseaConfig.class, id);
		return over;
	}

	@Override
	public void deleteover(OverseaConfig over) {
		  Session session=getSession();
		  session.delete(over);
	}

	@Override
	public void updateover(OverseaConfig over) {
		  Session session=getSession();
		  session.update(over);
	}

	@Override
	public Session getSession() {
		  return sessionFactory.getCurrentSession();
	}

	@Override
	public void saveover(OverseaConfig over) {
		Session session=getSession();
		  session.save(over);
		
	}

	//@Override
//	public OverseaConfigSubscribe overseaConfiggetById(int oversea_id) {
//		System.out.println(oversea_id);
//	  Session session=getSession();
//	  String hql="from OverseaConfigSubscribe  where id ="+id;
//		List<OverseaConfigSubscribe> list=session.createQuery(hql).list();
//		if(list.size()>0){
//			return list.get(0);
//		}
//		return null;
//	}
	}


