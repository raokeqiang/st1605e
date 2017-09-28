package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.News;
import com.profit.bean.NewsType;
import com.profit.dao.NewsDao;
@Component
public class NewsDaoImpl implements NewsDao<News>{

	@Autowired
	private SessionFactory sessionFactory;
	
	 public Session getSession(){
		 return sessionFactory.getCurrentSession();
	  }
	
	public List<News> listnews(String title,String typeid){
		System.out.println(typeid);
		Session session=getSession();
		String hql=" from News where 0=0";
		if(title!=null&&!"".equals(title)){
			hql+="and title like '%"+title+"%'" ;
		}
		if(typeid!=null&&!"".equals(typeid)){
			hql+="and typeid = '"+typeid+"'";
		}
		hql+="  ORDER BY sort";
		System.out.println(hql);
		List<News> list=session.createQuery(hql).list();
		return list;
	}
	public void saveews(News news){
		Session session=getSession();
		session.save(news);
	}
	public void update(News news){
		Session session=getSession();
		session.update(news);
	}
	public void delete(News news){
		Session session=getSession();
		session.delete(news);
	}
		

}
