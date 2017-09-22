package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.SubjectPurchaseRecord;
import com.profit.daoimpl.SubjectPurchaseRecordDao;
import com.profit.service.BackwService;

@Component
public class SubjectPurchaseRecordServiceImpl implements BackwService<SubjectPurchaseRecord>{

	@Autowired
	private SubjectPurchaseRecordDao subjectPurchaseRecordDao;

	@Override
	public void save(SubjectPurchaseRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SubjectPurchaseRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SubjectPurchaseRecord obj) {
		subjectPurchaseRecordDao.update(obj);
	}

	@Override
	public List<SubjectPurchaseRecord> listAll(Map map) {
		return subjectPurchaseRecordDao.listAll(map);
	}

	@Override
	public SubjectPurchaseRecord getById(int id) {
		return subjectPurchaseRecordDao.getById(id);
	}
}
