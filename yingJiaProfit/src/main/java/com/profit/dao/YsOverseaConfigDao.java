package com.profit.dao;
//海外配置

import java.util.List;

import org.hibernate.Session;

import com.profit.bean.OverseaConfig;
import com.profit.bean.OverseaConfigSubscribe;

public interface YsOverseaConfigDao {
	List<OverseaConfig> listAllover();
//	OverseaConfigSubscribe overseaConfiggetById(int oversea_id);
	List<OverseaConfigSubscribe>listover(int id);
	 OverseaConfig getoverById(int id);
	 void deleteover(OverseaConfig over);
	 void updateover(OverseaConfig over);
	 Session getSession();
	 void saveover(OverseaConfig over);
	}

