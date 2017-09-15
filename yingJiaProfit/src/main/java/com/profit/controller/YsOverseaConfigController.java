package com.profit.controller;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.OverseaConfig;
import com.profit.bean.OverseaConfigSubscribe;
import com.profit.service.YsoverseaConfigService;

@Controller
@RequestMapping("/over")
public class YsOverseaConfigController {
	@Autowired
	@Qualifier("ysoverseaConfigServiceImpl")
	private YsoverseaConfigService overService;
    
    
    @RequestMapping("/admin")
      public String admin(){
    	  return "admin";
      }
    //海外配置显示
    @RequestMapping("/Seamenus3")
	public String menus1(Model model){
    	List<OverseaConfig> list = overService.listAllover();
    	model.addAttribute("list", list);
		return "Seamenus3";
	}
    
    //海外配置新增
    @RequestMapping("/SeaoverAdd")
    public String toAdd(){
    	 //overService.saveover(over);
		return "SeaoverAdd";
   }

	@RequestMapping("/oadd")
    public String Add(OverseaConfig over){
    	over.setAddTime(new Date());
    	overService.saveover(over);
    	return "redirect:/over/Seamenus3";
   }
    //海外配置编辑查看
    @RequestMapping("/inData")
    public String inData(int id,Model model){
    	OverseaConfig over=this.overService.getById(id);
    	List<OverseaConfig>list=overService.listAllover();
    	model.addAttribute("over",over);
    	model.addAttribute("list",list);
		return "SeaEditmenus3";
    	
    }
    @RequestMapping("/update")
    public String update(OverseaConfig over,int id){
    	OverseaConfig  ov=overService.getById(id);
    	Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		ov.setAddTime(date);
		ov.setStart_time(date);
		ov.setEnd_time(date);
		ov.setUpdTime(date);
		ov.setAddTime(date);
    	overService.updateover(ov);
		return "redirect:/over/Seamenus3";
    	
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
       	List<OverseaConfigSubscribe> list2 = overService.listding();
       	model.addAttribute("list2", list2);
   		return "Sealistding";
   	}
   }
   
    