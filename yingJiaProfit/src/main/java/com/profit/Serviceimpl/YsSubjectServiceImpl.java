package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.FinanceProductSubscribe;
import com.profit.bean.Subject;
import com.profit.bean.SubjectBbinPurchassRecord;
import com.profit.dao.YsSubjectDao;
import com.profit.service.YsSubjectService;
@Service
@Transactional
public class YsSubjectServiceImpl implements YsSubjectService{
	@Autowired
	@Qualifier("ysSubjectDaoImpl")
	private YsSubjectDao subjectDao;
	@Override
	public List<Subject> listSubject(Map map) {
		return subjectDao.listSubject(map);
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

	@Override
	public List<SubjectBbinPurchassRecord> listp2pton() {
		return this.subjectDao.listp2pton();
	}

}
