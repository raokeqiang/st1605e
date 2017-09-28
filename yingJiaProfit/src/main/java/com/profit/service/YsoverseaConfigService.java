package com.profit.service;

import java.util.List;
import com.profit.bean.OverseaConfig;
import com.profit.bean.OverseaConfigSubscribe;
public interface YsoverseaConfigService {
void saveover(OverseaConfig over);
  void updateover(OverseaConfig over);
 void deleteover(OverseaConfig over);
 List<OverseaConfig> listAllover() ;
	OverseaConfig getById(int id) ;
//	//显示海外配置订阅
	//OverseaConfigSubscribe overseaConfiggetById(int oversea_id);
 List<OverseaConfigSubscribe> listding(int id) ;
	
}
