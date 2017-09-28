package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.PushNotice;
import com.profit.dao.PushNoticeDao;

//公告
@Component
public class PushNoticeDaoimpl implements PushNoticeDao<PushNotice>{

	@Autowired
	private SessionFactory sessionFactory;
	
	 public Session getSession(){
		 return sessionFactory.getCurrentSession();
	  }
	
	public List<PushNotice> listAllPushNotice(String title){
		Session session=getSession();
		String hql=" from PushNotice where 0=0 ";
		if(title!=null&&!"".equals(title)){
			hql+="and  title like '%"+title+"%'";
		}
		System.out.println(hql);
		List<PushNotice> list=session.createQuery(hql).list();
		return list;
	}
	public void updatePushNotice(PushNotice pushNotice){
		Session session=getSession();
		session.update(pushNotice);
	}
	public List<PushNotice> listByid(int id){
		String hql="from PushNotice where id="+id;
		System.out.println(hql);
		Session session=getSession();
		List<PushNotice> pushNotice=session.createQuery(hql).list();
		return pushNotice;
	}
	public void savePushNotice(PushNotice pushNotice){
		Session session=getSession();
		session.save(pushNotice);
	}

}
