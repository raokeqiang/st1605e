package com.profit.controller;


import java.util.Iterator;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profit.bean.Subject;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.service.YsSubjectService;

@Controller
@RequestMapping("/subject")
public class YsSubjectController {
	@Autowired
	@Qualifier("ysSubjectServiceImpl")
	private YsSubjectService subjectService;
	

@RequestMapping("/showp2p")
//显示盘p2p
	public String menus1(Model model){
	 	List<Subject> list = subjectService.listSubject();
	 	model.addAttribute("list", list);
	return "showp2p";
	}
    
  @RequestMapping("/getTotalMoney")
  @ResponseBody
   public double getTotalMoney(int id){
	  System.out.println("id:"+id);
	   Subject sub=this.subjectService.getById(id);
	   double num=0;
	   Set<SubjectPurchaseRecord> sets=sub.getSubjectPurchaseRecord();
	   if(sets.size()!=0){
	   Iterator<SubjectPurchaseRecord> records=sets.iterator();
	   while(records.hasNext()){
		   SubjectPurchaseRecord rec=records.next();
		  num+=rec.getAmount();
	   }
	   }
	   return num;
   }
@RequestMapping("/selectSub")
public String selectSub(int id,Model model){
	Subject sub=subjectService.getById(id);
	List<Subject> list = subjectService.listSubject();
	model.addAttribute("sub",sub);
	model.addAttribute("list",list);
	return "p2pEdit";
	
}

}
