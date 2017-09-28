package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.News;
import com.profit.dao.NewsDao;
import com.profit.service.NewsService;

@Service
@Transactional
public class NewsServiceImpl implements NewsService<News>{
	@Autowired
	@Qualifier("newsDaoImpl")
	private NewsDao newsDaoImpl;

	public List<News> listnews(String title, String typeid) {
		return newsDaoImpl.listnews(title, typeid);
	}

	public void update(News news) {
		newsDaoImpl.update(news);
	}

	public void delete(News news) {
		newsDaoImpl.delete(news);
	}

	public void saveews(News news) {
		newsDaoImpl.saveews(news);
	}
}
