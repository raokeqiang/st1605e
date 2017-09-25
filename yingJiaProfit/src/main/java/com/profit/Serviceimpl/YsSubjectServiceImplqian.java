package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.Subject;
import com.profit.dao.YsSubjectDaoqian;
import com.profit.service.YsSubjectServiceqian;
@Service
@Transactional
public class YsSubjectServiceImplqian implements YsSubjectServiceqian{
	@Autowired
	@Qualifier("ysSubjectDaoqianImpl")
	private YsSubjectDaoqian subjectDaoqian;

	@Override
	public List<Subject> list(Map map) {
		return 	this.subjectDaoqian.list(map);
	}

	@Override
	public List<Subject> query(String hql) {
		return this.subjectDaoqian.query(hql);
	}	




}
