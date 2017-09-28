package com.profit.Serviceimpl;


import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.NewsType;
import com.profit.dao.NewsTypeDao;
import com.profit.service.NewsTypeService;
@Service
@Transactional
public class NewsTypeServiceImpl implements NewsTypeService{
	@Autowired
	@Qualifier("newsTypeDaoImpl")
	private NewsTypeDao newsTypeDaoImpl;

	public void savetype(Object t) {
		newsTypeDaoImpl.savetype(t);
	}

	public List<NewsType> listType() {
		return newsTypeDaoImpl.listType();
	}

	public void updateType(Object t) {
		newsTypeDaoImpl.updateType(t);
	}

	 
}
