package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.MemberDepositRecord;
import com.profit.service.BackwService;

@Controller
@RequestMapping("/Recharge")
public class BackMemberDepositRecordController {
													//充值管理
	@Resource(name="memberDepositRecordServiceImpl")
	private BackwService memberDepositRecordServiceImpl;
	
	@RequestMapping("/listAll")
	public String listAll(Model model,String qorderno,String qmobile_Phone,String qstatus,
			String qfuiouno,String qtime){
	  	  Map map=new HashMap();
	  	    map.put("member_id",0 );
		    map.put("qorderno",qorderno);
		    map.put("qmobile_Phone",qmobile_Phone);
		    map.put("qstatus",qstatus);
		    map.put("qfuiouno",qfuiouno);
		    map.put("qtime",qtime);
	 List<MemberDepositRecord> listAll=memberDepositRecordServiceImpl.listAll(map);
		model.addAttribute("listAll",listAll);
		model.addAttribute("qorderno", qorderno);
		model.addAttribute("qmobile_Phone", qmobile_Phone);
		model.addAttribute("qstatus", qstatus);
		model.addAttribute("qfuiouno", qfuiouno);
		model.addAttribute("qtime", qtime);
		return "/Recharge";
	}
}
