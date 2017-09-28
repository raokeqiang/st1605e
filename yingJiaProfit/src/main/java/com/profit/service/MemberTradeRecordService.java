package com.profit.service;

import java.util.List;
import java.util.Map;

import com.profit.bean.MemberTradeRecord;

public interface MemberTradeRecordService {

	 List<MemberTradeRecord> listAll(Map map);
	 String listhql(Map map,String hql);
}
