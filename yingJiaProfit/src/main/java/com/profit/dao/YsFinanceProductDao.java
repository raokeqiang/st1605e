package com.profit.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.profit.bean.FinanceProductFunds;

public interface YsFinanceProductDao {
List<FinanceProductFunds> showmoney(Map map);
String listDataHql(String hql,Map map);
void addmoney(FinanceProductFunds finance);
Session getSession();
}
