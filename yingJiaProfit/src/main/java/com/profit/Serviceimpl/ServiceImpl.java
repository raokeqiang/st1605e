package com.profit.Serviceimpl;

import java.util.List;

public interface ServiceImpl {
	
	public <T> List<T> listAll(Object...objects);
	
	public void save(Object object);
	
	public void delete(Object object);
	
	public void update(Object object);
	
	public <T> T getById(int id);

}
