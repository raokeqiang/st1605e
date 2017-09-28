package com.profit.service;

import java.util.List;


public interface NewsService<T> {

	List<T> listnews(String title,String typeid);
	void update(T t);
	void delete(T t);
	void saveews(T t);
}
