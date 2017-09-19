package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.profit.bean.FinanceProductFunds;
import com.profit.service.YsFinanceProductService;

@Controller
@RequestMapping("/qianmoney")
public class YsFinanceMoneyqianController {
	@Autowired
	@Qualifier("ysFinanceProductServiceImpl")
	private YsFinanceProductService financeService;

@RequestMapping("/showmon")
public String showmoney(Model model,@RequestParam(required=false)String name,
		@RequestParam(required=false)String type,@RequestParam(required=false)String status){
	Map map=new HashMap();
	map.put("name", name);
	map.put("type", type);
	map.put("status", status);
	List<FinanceProductFunds> list=financeService.showmoney(map);
	model.addAttribute("list", list);
	model.addAttribute("name", name);
	model.addAttribute("type",type);
	model.addAttribute("status",status);
	return "front/showmoney";
	}
}