package com.profit.service;

import java.util.List;

public interface NewsTypeService<T> {
	List<T> listType();
	void updateType(T t);
	void savetype(T t);
}
