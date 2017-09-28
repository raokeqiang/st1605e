package com.profit.dao;

import java.util.List;


public interface NewsDao<T> {

	List<T> listnews(String title,String typeid);
	void update(T t);
	void delete(T t);
	void saveews(T t);
}
