package com.profit.daoimpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Subject;
import com.profit.dao.YsSubjectDao;

@Component
public class YsSubjectDaoImpl implements YsSubjectDao{
	@Autowired
	public SessionFactory sessionFactory;

	@Override
	public Session getSession() {
		 return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Subject> listSubject() {
		  Session session=getSession();
		  List<Subject> list=session.createQuery("from Subject").list();
		  return list;
	}

	@Override
	public Subject getById(int id) {
		Subject sub=(Subject)this.getSession().get(Subject.class, id);
		return sub;
	}

	@Override
	public void updateSub(Subject sub) {
		Session session=getSession();
		session.update(sub);
	}
}
