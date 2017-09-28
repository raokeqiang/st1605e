package com.profit.dao;

import java.util.List;
import java.util.Map;

import com.profit.bean.MemberTradeRecord;

public interface MemberTradeRecordDao {

	 List<MemberTradeRecord> listAll(Map map);
	 String listhql(Map map,String hql);
}
