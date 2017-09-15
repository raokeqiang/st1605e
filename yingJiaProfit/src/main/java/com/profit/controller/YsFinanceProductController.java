package com.profit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
@RequestMapping("/money")
public class YsFinanceProductController {
	@Autowired
	@Qualifier("ysFinanceProductServiceImpl")
	private YsFinanceProductService financeService;

@RequestMapping("/showmoney")
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
	return "showmoney";
	}
@RequestMapping("/toAddmoney")
public String toAddmoney(){
	return "moneyAdd";
}
@RequestMapping("/moneyAdd")
public String moneyAdd(FinanceProductFunds finance){
	Date now=new Date();
	SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	String hehe=dateFormat.format(now);
	
	Date date = null;
	try {
		date = dateFormat.parse(hehe);
	} catch (ParseException e) {
		e.printStackTrace();
	}
	finance.setCreate_date(date);
	finance.setUpdate_date(date);
	finance.setStart_date(date);
	finance.setEnd_date(date);
	finance.setInvest_points("");
	  financeService.addmoney(finance);
	  return"redirect:/money/showmoney";
}
}