package com.profit.dao;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import com.profit.bean.FinanceProductFunds;
import com.profit.bean.FinanceProductSubscribe;

public interface YsFinanceProductDao {
List<FinanceProductFunds> showmoney(Map map);
String listDataHql(String hql,Map map);
void addmoney(FinanceProductFunds finance);
Session getSession();
void update(FinanceProductFunds finance);
FinanceProductFunds getById(int id);//私募产品
List<FinanceProductSubscribe> showmoneyding(int id);//显示签署状态
FinanceProductSubscribe getByIding(int id);//签署和产品外键关联
//保存签署合同
void updatehe(FinanceProductSubscribe fina);

}
