package com.profit.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Subject;
import com.profit.bean.SubjectBbinPurchassRecord;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.service.BackServicetwo;
import com.profit.service.BackwService;

@Controller
@RequestMapping("/Payint")
public class BackSubjectController {
	                                 //付息计划
@Resource(name="subjectServiceImpl")
private BackServicetwo<Subject> subjectServiceImpl;
@Resource(name="subjectPurchaseRecordServiceImpl")
private BackwService<SubjectPurchaseRecord> subjectPurchaseRecordServiceImpl;
@Resource(name="subjectBbinPurchassRecordServiceImpl")
private BackwService<SubjectBbinPurchassRecord> subjectBbinPurchassRecordServiceImpl;

@RequestMapping("/listAll")
public String listAll(Model model,Map map,String qname,String qstatus,String qtype){
	 map.put("qname",qname);
	 map.put("qstatus",qstatus);
	 map.put("qtype",qtype);
     List<SubjectPurchaseRecord> listAll=subjectServiceImpl.listRange(map);
     model.addAttribute("qname",qname);
     model.addAttribute("qstatus",qstatus);
     model.addAttribute("qtype",qtype);
     model.addAttribute("listAll",listAll);
     return "/Payint";
}
@RequestMapping("/Payment")   //付息列表
public String Bbin(Model model,Map map,int id){
	 map.put("subject_id",id );
     List<SubjectPurchaseRecord> list=subjectPurchaseRecordServiceImpl.listAll(map);
     model.addAttribute("subject_id",id);
     model.addAttribute("list",list);
     return "/Payment";
}
@RequestMapping("/Bbin")      //体验金付息
public String Payment(Model model,Map map,int id){
	 map.put("subject_id",id );
     List<SubjectBbinPurchassRecord> list=subjectBbinPurchassRecordServiceImpl.listAll(map);
     model.addAttribute("subject_id",id);
     model.addAttribute("list",list);
     return "/Bbin";
}
@RequestMapping("/Ppary")      //付息还款操作
public String Ppary(Model model,int id,int sid){
	System.out.println("123");
	SubjectPurchaseRecord subjectPurchaseRecord=subjectPurchaseRecordServiceImpl.getById(id);
	subjectPurchaseRecord.setIspayment(0);
	subjectPurchaseRecordServiceImpl.update(subjectPurchaseRecord);
     return "redirect:/Payint/Payment?id=${"+sid+" }";
}
@RequestMapping("/Bpary")      //体验金还款操作
public String Bpary(Model model,int id,int sid){
	System.out.println("456");
	SubjectBbinPurchassRecord subjectBbinPurchassRecord=subjectBbinPurchassRecordServiceImpl.getById(id);
	subjectBbinPurchassRecord.setIspayment(0);
	subjectBbinPurchassRecordServiceImpl.update(subjectBbinPurchassRecord);
	return "redirect:/Payint/Bbin?id=${"+sid+"}";
}

}
