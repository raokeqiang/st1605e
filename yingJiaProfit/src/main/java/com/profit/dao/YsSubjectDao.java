package com.profit.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.profit.bean.Subject;
import com.profit.bean.SubjectBbinPurchassRecord;
//固守类p2p
public interface YsSubjectDao{
   Session getSession();
	 List<Subject >listSubject(Map map);
	  Subject getById(int id);
	  void updateSub(Subject sub);
	  void p2pAdd(Subject sub);
	  String listDataHql(String hql,Map map);
	List<SubjectBbinPurchassRecord> listp2pton();//查询投资表
	}
