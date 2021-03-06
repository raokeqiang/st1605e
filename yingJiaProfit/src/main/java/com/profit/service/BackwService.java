package com.profit.service;

import java.util.List;
import java.util.Map;

public interface BackwService<T>{

	public void save(T obj);
	public void delete(T obj);
	public void update(T obj);
 	public List<T> listAll(Map map);
 	public T getById(int id);
}
