package com.profit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.profit.bean.oversea_config;
import com.profit.bean.oversea_config_subscribe;
import com.profit.dao.YsOverseaConfigDao;

@Service
@Transactional
public class YsoverseaConfigService  {
	@Autowired
   private YsOverseaConfigDao overDao;
	
	public void saveover(oversea_config over){
		this.overDao.saveover(over);
	}
	
	public void updateover(oversea_config over){
		this.overDao.updateover(over);
	}
	public void deleteover(oversea_config over){
		this.overDao.deleteover(over);
	}
	public List<oversea_config> listAllover() {
		return overDao.listAllover();
	}
	public oversea_config getById(int id) {
		return overDao.getById(id);
	}
//	//显示海外配置订阅
	public List<oversea_config_subscribe> listding() {
		return overDao.listover();
	}
}
