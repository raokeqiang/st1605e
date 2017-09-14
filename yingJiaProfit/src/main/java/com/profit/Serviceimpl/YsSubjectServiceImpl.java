package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.Subject;
import com.profit.dao.YsSubjectDao;
import com.profit.service.YsSubjectService;
@Service
@Transactional
public class YsSubjectServiceImpl implements YsSubjectService{
	@Autowired
	@Qualifier("ysSubjectDaoImpl")
	private YsSubjectDao subjectDao;
	@Override
	public List<Subject> listSubject() {
		return subjectDao.listSubject();
	}

	@Override
	public Subject getById(int id) {
		Subject sub=this.subjectDao.getById(id);
		return sub;
	}

	@Override
	public void updateSub(Subject sub) {
		this.subjectDao.updateSub(sub);
	}

	@Override
	public void p2pAdd(Subject sub) {
   this.subjectDao.p2pAdd(sub);		
	}

}
