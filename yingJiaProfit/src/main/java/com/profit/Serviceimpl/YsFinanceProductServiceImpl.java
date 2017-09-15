package com.profit.Serviceimpl;

import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profit.bean.FinanceProductFunds;
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

}
