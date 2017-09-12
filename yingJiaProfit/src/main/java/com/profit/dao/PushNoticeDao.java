package com.profit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.PushNotice;

//公告
@Component
public class PushNoticeDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	 public Session getSession(){
		 return sessionFactory.getCurrentSession();
	  }
	
	public List<PushNotice> listAllPushNotice(String title){
		Session session=getSession();
		String hql="from PushNotice  ";
		if(title!=null&&!"".equals(title)){
			hql+="where title like %"+title+"%";
		}
		System.out.println(hql);
		List<PushNotice> list=session.createQuery(hql).list();
		return list;
	}
	public void updatePushNotice(PushNotice pushNotice){
		Session session=getSession();
		session.update(pushNotice);
	}
	public PushNotice listByid(int id){
		String hql="from PushNotice where id="+id;
		Session session=getSession();
		PushNotice list=(PushNotice)session.createQuery(hql);
		return list;
	}
	public void savePushNotice(PushNotice pushNotice){
		Session session=getSession();
		session.save(pushNotice);
	}
}
