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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.profit.bean.FinanceProductFunds;
import com.profit.bean.FinanceProductSubscribe;
import com.profit.bean.Subject;
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
@RequestMapping("/moneyEdit")
public String moneyEdit(int id,Model model){
	Map map=new HashMap<>();
	FinanceProductFunds finance = financeService.getById(id);
	List<FinanceProductFunds> list=financeService.showmoney(map);
	model.addAttribute("finance", finance);
	model.addAttribute("list", list);
	return "moneyEdit";
}
@RequestMapping("/update")
public String update(FinanceProductFunds finance){
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
	financeService.updatemoney(finance);
	return "redirect:/money/showmoney";
}
//显示签署状态
@RequestMapping("/moneyding/{id}")
public String moneyding(Model model,@PathVariable("id")int id){
	System.out.println("111111111111");
	List<FinanceProductSubscribe> list=financeService.showmoneyding(id);
	model.addAttribute("list",list);
	System.out.println(list.size());
  return "showmoneyding";
}
//点击签署，签订合约
@RequestMapping("/heyue/{id}")
public String heyue(Model model,@PathVariable("id")int id){
	System.out.println("id="+id);
	FinanceProductSubscribe finan=financeService.getByIding(id);
	model.addAttribute("finan",finan);
	return "showhe";
}
//保存签署合同
@RequestMapping("/savehe")
public String savehe(Model model,FinanceProductSubscribe finance){
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
	financeService.savehe(finance);
	return "redirect:/money/showmoneyding";
}
}