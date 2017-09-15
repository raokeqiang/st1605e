package com.profit.daoimpl;

import java.util.List;

import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Subject;
import com.profit.bean.SubjectBbinPurchassRecord;
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
	public List<Subject> listSubject(Map map) {
		String hql="from Subject where 0=0";
		hql=listDataHql(hql, map);
		  Session session=getSession();
		  List<Subject> list=session.createQuery(hql).list();
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

	@Override
	public void p2pAdd(Subject sub) {
     Session session=getSession();
     session.save(sub);
	}

	@Override
	public String listDataHql(String hql, Map map) {
		String name=(String)map.get("name");
			String stype=(String)map.get("stype");
			String status=(String)map.get("status");
			if(name!=null&&!name.equals("")){
				hql+=" and name like '%"+name+"%'";
			}
			if(stype!=null&&!stype.equals("")){
				hql+=" and type like '%"+stype+"%'";
			}
			if(status!=null&&!status.equals("")){
				hql+=" and status like '%"+status+"%'";
			}

			return hql;
		}
	@Override
	public List<SubjectBbinPurchassRecord> listp2pton() {
		Session session=getSession();
		 List<SubjectBbinPurchassRecord> list2=session.createQuery("from SubjectBbinPurchassRecord").list();
		  return list2;
	}
	
	}

