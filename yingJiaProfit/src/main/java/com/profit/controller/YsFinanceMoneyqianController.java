package com.profit.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.FinanceProductFunds;
import com.profit.service.YsFinanceProductService;

@Controller
@RequestMapping("/qianmoney")
public class YsFinanceMoneyqianController {
	@Autowired
	@Qualifier("ysFinanceProductServiceImpl")
	private YsFinanceProductService financeService;

@RequestMapping("/privmon")
public String showmoney(Model model){
	Map map=new HashMap();
	List<FinanceProductFunds> list=financeService.showmoney(map);
	model.addAttribute("list", list);
	return "front/showmoney";
	}
}