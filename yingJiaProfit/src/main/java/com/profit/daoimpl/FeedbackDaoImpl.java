package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.BbinInfo;
import com.profit.bean.FeedBack;
import com.profit.dao.FeedbackDao;
@Component
public class FeedbackDaoImpl implements FeedbackDao<FeedBack>{
	@Autowired
	private SessionFactory sessionFactory;
	
	 public Session getSession(){
		 return sessionFactory.getCurrentSession();
	  }
	public List<FeedBack> listFeedback(){
		Session session=getSession();
		String hql=" from FeedBack ";
		List<FeedBack> list=session.createQuery(hql).list();
		return list;
	}
	public void saveF(FeedBack feedback){
		Session session=getSession();
		session.save(feedback);
	}
}
