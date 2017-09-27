package com.profit.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.service.GgManagerService;

@Controller
@RequestMapping("/GongGao")
public class YjTopController {

	@Autowired
	@Qualifier("ggManagerServiceImpl")
	private GgManagerService ggManagerService;
	
	
		//红包统计
		@RequestMapping("/serCop")
		public String serCop(Model model,String creatTime,String endTime,String month,String vs){
			System.out.println(month);
			if("this".equals(month)){
				Date now=new Date();
				Date now2=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
				
				vs =dateFormat.format(now);
				vs +="-01";
				 now2.setMonth(now.getMonth()+1);
				 
				 month=dateFormat.format(now2);
				 month+="-01";
			}
			if("shang".equals(month)){
				Date now=new Date();
				Date now2=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
				
				 month=dateFormat.format(now);
				 month+="-01";
				 now2.setMonth(now.getMonth()-1);
				 
				 vs=dateFormat.format(now2);
				 vs+="-01";
			}
			if("san".equals(month)){
				Date now=new Date();
				Date now2=new Date();
				SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM");
				
				 month=dateFormat.format(now);
				 month+="-01";
				 now2.setMonth(now.getMonth()-3);
				 
				 vs=dateFormat.format(now2);
				 vs+="-01";
			}
			List list =this.ggManagerService.ListCop(creatTime,vs,month);
			List list2=this.ggManagerService.ListCop1(creatTime,vs,month);
			List list3=this.ggManagerService.ListCop2(creatTime,endTime,vs,month);
			List list4=this.ggManagerService.ListCop3(creatTime,endTime,vs,month);
			List list5=this.ggManagerService.ListCop4(creatTime,endTime,vs,month);
			List list6=this.ggManagerService.ListCop5(creatTime,vs,month);
			List list7=this.ggManagerService.ListCop6(creatTime,vs,month);
			List list8=this.ggManagerService.ListCop7(creatTime,vs,month);
			List list9=this.ggManagerService.ListCop8(creatTime,vs,month);
			List list10=this.ggManagerService.ListCop9(creatTime,endTime,vs,month);
			List list11=this.ggManagerService.ListCop10(creatTime,endTime,vs,month);
			List list12=this.ggManagerService.ListCop11(creatTime,endTime,vs,month);
			List list13=this.ggManagerService.ListCop12(creatTime,vs,month);
			List list14=this.ggManagerService.ListCop13(creatTime,vs,month);
			List list15=this.ggManagerService.ListCop14(creatTime,vs,month);
			model.addAttribute("list", list);
			model.addAttribute("list2", list2);
			model.addAttribute("list3", list3);
			model.addAttribute("list4", list4);
			model.addAttribute("list5", list5);
			model.addAttribute("list6", list6);
			model.addAttribute("list7", list7);
			model.addAttribute("list8", list8);
			model.addAttribute("list9", list9);
			model.addAttribute("list10", list10);
			model.addAttribute("list11", list11);
			model.addAttribute("list12", list12);
			model.addAttribute("list13", list13);
			model.addAttribute("list14", list14);
			model.addAttribute("list15", list15);
			return "YjCop";
		}
	
	
}
