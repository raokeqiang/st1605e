package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.AwardRecords;
import com.profit.bean.Range;
import com.profit.daoimpl.AwardRecordsDao;
import com.profit.service.BackServicetwo;

@Component
public class AwardRecordsServiceImpl implements BackServicetwo<AwardRecords> {

	@Autowired
	private AwardRecordsDao awardRecordsDao;

	@Override
	public void save(AwardRecords obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(AwardRecords obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(AwardRecords obj) {
		 awardRecordsDao.update(obj);
	}

	@Override
	public List<AwardRecords> listAll(Map map) {
		return awardRecordsDao.ListAll(map);
	}

	@Override
	public AwardRecords getById(int id) {
		return awardRecordsDao.getById(id);
	}

	@Override
	public List<Range> listRange(Map map) {
		return awardRecordsDao.ListRangeAll(map);
	}
	

}
