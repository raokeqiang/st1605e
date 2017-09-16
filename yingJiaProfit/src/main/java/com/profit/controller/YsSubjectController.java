package com.profit.controller;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profit.bean.Subject;
import com.profit.bean.SubjectBbinPurchassRecord;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.service.YsSubjectService;

@Controller
@RequestMapping("/subject")
public class YsSubjectController {
	@Autowired
	@Qualifier("ysSubjectServiceImpl")
	private YsSubjectService subjectService;

	@RequestMapping("/showp2p")
	// 显示盘p2p
	public String menus1(Model model,@RequestParam(required=false)String name,
	@RequestParam(required=false)String stype,@RequestParam(required=false)String status) {
		Map map=new HashMap<>();
		map.put("name", name);
		map.put("stype", stype);
		map.put("status", status);
		List<Subject> list = subjectService.listSubject(map);
		model.addAttribute("list", list);
		model.addAttribute("name", name);
		model.addAttribute("stype",stype);
		model.addAttribute("status",status);
		return "showp2p";
	}
//计算总金额
	@RequestMapping("/getTotalMoney")
	@ResponseBody
	public double getTotalMoney(int id) {
		System.out.println("id:" + id);
		Subject sub = this.subjectService.getById(id);
		double num = 0;
		Set<SubjectPurchaseRecord> sets = sub.getSubjectPurchaseRecord();
		if (sets.size() != 0) {
			Iterator<SubjectPurchaseRecord> records = sets.iterator();
			while (records.hasNext()) {
				SubjectPurchaseRecord rec = records.next();
				num += rec.getAmount();
			}
		}
		return num;
	}



	// 固守编辑修改
	@RequestMapping("/selectSub")
	public String selectSub(int id, Model model) {
		Map map=new HashMap<>();
		Subject sub = subjectService.getById(id);
		List<Subject> list = subjectService.listSubject(map);
		model.addAttribute("sub", sub);
		model.addAttribute("list", list);
		return "p2pEdit";
	}

	@RequestMapping("/update")
	public String update(Subject sub) {
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sub.setCreate_date(date);
		sub.setUpdate_date(date);
		sub.setRaise_end(date);
		sub.setRaise_start(date);
		subjectService.updateSub(sub);
		return "redirect:/subject/showp2p";
	}

	// 固守新增
	@RequestMapping("/p2ptoAdd")
	public String p2ptoAdd() {
		return "p2ptoAdd";
	}
	@RequestMapping("/p2pAdd")
	public String p2pAdd(Subject sub){
//		sub.setCreate_date(new Date());
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		sub.setCreate_date(date);
		sub.setUpdate_date(date);
		sub.setRaise_end(date);
		sub.setRaise_start(date);
		subjectService.p2pAdd(sub);
		return "redirect:/subject/showp2p";
		
	}

	// 固守查看投资
	@RequestMapping("/selectp2p")
	public String selectp2p(Model model) {
		List<SubjectBbinPurchassRecord>list2=subjectService.listp2pton();
	    model.addAttribute("list2",list2);
	    System.out.println(list2.size());
	return "p2pton";
	}
	//计算利息
	@RequestMapping("/getdate")
	@ResponseBody
//	// 年化收益：投资金额*年化率/365*周期
	public double getdate(int id) {
	System.out.println("id:" + id);
		Subject sub = this.subjectService.getById(id);
		int firstmoney = sub.getFloor_amount();// 起头金额
		int date = sub.getYear_rate();// 年化率
		int t = sub.getPeriod();// 标的周期
		double shou = ((firstmoney * date) / 365) * t;
		System.out.println("shou=" + shou);
		return shou;
	}
}