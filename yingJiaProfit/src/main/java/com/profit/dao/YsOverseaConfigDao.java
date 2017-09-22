package com.profit.dao;
//海外配置

import java.util.List;

import org.hibernate.Session;

import com.profit.bean.OverseaConfig;
import com.profit.bean.OverseaConfigSubscribe;

public interface YsOverseaConfigDao {
	List<OverseaConfig> listAllover();
	List<OverseaConfigSubscribe>listover();
	 OverseaConfig getoverById(int id);
	 void deleteover(OverseaConfig over);
	 void updateover(OverseaConfig over);
	 Session getSession();
	 void saveover(OverseaConfig over);
	}

