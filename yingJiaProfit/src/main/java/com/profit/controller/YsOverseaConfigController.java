package com.profit.controller;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.oversea_config;
import com.profit.bean.oversea_config_subscribe;
import com.profit.service.YsoverseaConfigService;

@Controller
@RequestMapping("/over")
public class YsOverseaConfigController {
    @Autowired
    private YsoverseaConfigService overService;
    @RequestMapping("/admin")
      public String admin(){
    	  return "admin";
      }
    //海外配置显示
    @RequestMapping("/ysmenus3")
	public String menus1(Model model){
    	List<oversea_config> list = overService.listAllover();
    	model.addAttribute("list", list);
		return "ysmenus3";
	}
    
    //海外配置新增
    @RequestMapping("toAdd")
    public String toAdd(Model model ){
    	List<oversea_config> list = overService.listAllover();
    	model.addAttribute("list", list);
		return "ysAddmenus3";
    	
    }
    //海外配置编辑查看
    @RequestMapping("/inData")
    public String inData(int id,Model model){
    	oversea_config over=this.overService.getById(id);
    	List<oversea_config>list=overService.listAllover();
    	model.addAttribute("over",over);
    	model.addAttribute("list",list);
		return "ysEditmenus3";
    	
    }
    @RequestMapping("/update")
    public String update(oversea_config over,int id){
    	oversea_config  ov=overService.getById(id);
    	overService.updateover(ov);
		return "redirect:/over/ysmenus3";
    	
    }
//    //显示海外配置预约记录
//    @RequestMapping("/listding")
//    public String listding(Model model){
//    	List<oversea_config_subscribe> list2 = overService.listding();
//    	model.addAttribute("list2", list2);
//    	return "yslistding";
//    }
    @RequestMapping("/listding")
   	public String list(Model model){
       	List<oversea_config_subscribe> list2 = overService.listding();
       	model.addAttribute("list2", list2);
   		return "yslistding";
   	}
   }
   
    