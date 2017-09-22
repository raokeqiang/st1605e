package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.Subject;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.daoimpl.SubjectDao;
import com.profit.service.BackServicetwo;

@Component
public class SubjectServiceImpl implements BackServicetwo<Subject>{

	@Autowired
	private SubjectDao subjectDao;
	
	@Override
	public void save(Subject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Subject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Subject obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Subject> listAll(Map map) {
		return subjectDao.ListAll(map);
	}

	@Override
	public Subject getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<SubjectPurchaseRecord> listRange(Map map) {
		return subjectDao.listRange(map);
	}

}
