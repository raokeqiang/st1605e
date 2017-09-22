package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.SubjectBbinPurchassRecord;
import com.profit.daoimpl.SubjectBbinPurchassRecordDao;
import com.profit.service.BackwService;

@Component
public class SubjectBbinPurchassRecordServiceImpl  implements BackwService<SubjectBbinPurchassRecord>{
                                                         //体验金付息
	@Autowired
	private SubjectBbinPurchassRecordDao subjectBbinPurchassRecordDao;
	@Override
	public void save(SubjectBbinPurchassRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(SubjectBbinPurchassRecord obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(SubjectBbinPurchassRecord obj) {
		subjectBbinPurchassRecordDao.update(obj);
	}

	@Override
	public List<SubjectBbinPurchassRecord> listAll(Map map) {
		return subjectBbinPurchassRecordDao.listAll(map);
	}

	@Override
	public SubjectBbinPurchassRecord getById(int id) {
		return subjectBbinPurchassRecordDao.getById(id);
	}

}
