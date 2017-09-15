package com.profit.service;

import java.util.List;
import java.util.Map;

import com.profit.bean.FinanceProductFunds;

public interface YsFinanceProductService {
List<FinanceProductFunds>showmoney(Map map);
void addmoney(FinanceProductFunds finance);
}
