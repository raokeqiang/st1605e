package com.profit.dao;

import java.util.List;

public interface NewsTypeDao<T> {

	List<T> listType();
	void updateType(T t);
	void savetype(T t);
}
