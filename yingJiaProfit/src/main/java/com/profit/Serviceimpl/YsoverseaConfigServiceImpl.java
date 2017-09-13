package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.profit.bean.OverseaConfig;
import com.profit.bean.OverseaConfigSubscribe;
import com.profit.dao.YsOverseaConfigDao;
import com.profit.service.YsoverseaConfigService;
@Service
@Transactional
public class YsoverseaConfigServiceImpl implements YsoverseaConfigService{
	@Autowired
	private YsOverseaConfigDao ysOverseaImpl;
	
	@Override
	public void saveover(OverseaConfig over) {
		this.ysOverseaImpl.saveover(over);	
	}

	@Override
	public void updateover(OverseaConfig over) {
		this.ysOverseaImpl.updateover(over);		
	}

	@Override
	public void deleteover(OverseaConfig over) {
		this.ysOverseaImpl.deleteover(over);		
	}

	@Override
	public List<OverseaConfig> listAllover() {
		return ysOverseaImpl.listAllover();
	}

	@Override
	public OverseaConfig getById(int id) {
		return ysOverseaImpl.getoverById(id);
		
	}

	@Override
	public List<OverseaConfigSubscribe> listding() {
		return ysOverseaImpl.listover();
	}

}
