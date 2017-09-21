package com.profit.service;

import java.util.List;
import java.util.Map;

import com.profit.bean.FinanceProductFunds;
import com.profit.bean.FinanceProductSubscribe;

public interface YsFinanceProductService {
List<FinanceProductFunds>showmoney(Map map);
void addmoney(FinanceProductFunds finance);
void updatemoney(FinanceProductFunds finance);
FinanceProductFunds getById(int id);
FinanceProductSubscribe getByIding(int id);
List<FinanceProductSubscribe> showmoneyding(int id);//显示签署状态
//保存签署合同
void updatehe(FinanceProductSubscribe fina);
}
