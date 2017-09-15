package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profit.bean.FinanceProductFunds;
import com.profit.bean.FinanceProductSubscribe;
import com.profit.dao.YsFinanceProductDao;
import com.profit.service.YsFinanceProductService;
@Service
@Transactional
public class YsFinanceProductServiceImpl implements YsFinanceProductService {
	@Autowired
	private YsFinanceProductDao ysFinanceProductDao;
	@Override
	public List<FinanceProductFunds> showmoney(Map map) {
		
		return this.ysFinanceProductDao.showmoney(map);
	}

	@Override
	public void addmoney(FinanceProductFunds finance) {
    this.ysFinanceProductDao.addmoney(finance);		
	}

	@Override
	public void updatemoney(FinanceProductFunds finance) {
  this.ysFinanceProductDao.update(finance);		
	}

	@Override
	public FinanceProductFunds getById(int id) {
		return this.ysFinanceProductDao.getById(id);
	}
//显示签署状态
	@Override
	public List<FinanceProductSubscribe> showmoneyding(int id) {
	return this.ysFinanceProductDao.showmoneyding(id);
	}

	@Override
	public FinanceProductSubscribe getByIding(int id) {
		return this.ysFinanceProductDao.getByIding(id);
	}

	@Override
	public void savehe(FinanceProductSubscribe fina) {
		this.ysFinanceProductDao.savehe(fina);
    	}



}
