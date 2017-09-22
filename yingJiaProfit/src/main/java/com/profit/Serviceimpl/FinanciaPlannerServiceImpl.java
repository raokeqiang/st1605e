package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.profit.bean.FinanciaPlanner;
import com.profit.daoimpl.FinanciaPlannerDao;
import com.profit.service.BackwService;

@Component
public class FinanciaPlannerServiceImpl implements BackwService<FinanciaPlanner>{

	@Autowired
	private FinanciaPlannerDao financiaPlannerDao;

	@Override
	public void save(FinanciaPlanner obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(FinanciaPlanner obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(FinanciaPlanner obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<FinanciaPlanner> listAll(Map map) {
		return financiaPlannerDao.ListAll(map);
	}

	@Override
	public FinanciaPlanner getById(int id) {
		// TODO Auto-generated method stub
		return financiaPlannerDao.getById(id);
	}
}
