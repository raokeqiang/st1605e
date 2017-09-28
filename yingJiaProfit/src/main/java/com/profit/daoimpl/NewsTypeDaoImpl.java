package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.NewsType;
import com.profit.dao.NewsTypeDao;
@Component
public class NewsTypeDaoImpl implements NewsTypeDao<NewsType>{
	@Autowired
	private SessionFactory sessionFactory;
	
	 public Session getSession(){
		 return sessionFactory.getCurrentSession();
	  }
	public List<NewsType> listType(){
		Session session=getSession();
		String hql="from NewsType ORDER BY sort";
		List<NewsType> list=session.createQuery(hql).list();
		return list;
	}
	public void updateType(NewsType newstype){
		Session session=getSession();
		session.update(newstype);
	}
	public void savetype(NewsType newstype){
		Session session=getSession();
		session.save(newstype);
	}
}
