package com.profit.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.OverseaConfig;
import com.profit.service.YsoverseaConfigService;

@Controller
@RequestMapping("/sea")
public class YsShowOverseaqianController {
	@Autowired
	@Qualifier("ysoverseaConfigServiceImpl")
	private YsoverseaConfigService overService;

//海外配置显示前台
@RequestMapping("/showsea")
public String menus1(Model model){
	List<OverseaConfig> list = overService.listAllover();
	model.addAttribute("list", list);
	System.out.println(list.size());
	return "front/showsea";
}
}