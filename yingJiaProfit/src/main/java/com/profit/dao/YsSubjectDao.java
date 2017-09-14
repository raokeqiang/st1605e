package com.profit.dao;

import java.util.List;


import org.hibernate.Session;

import com.profit.bean.Subject;
//固守类p2p
public interface YsSubjectDao{
   Session getSession();
	 List<Subject >listSubject();
	  Subject getById(int id);
	  void updateSub(Subject sub);
	  void p2pAdd(Subject sub);
	}
