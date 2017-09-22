package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.MemberBankcards;
import com.profit.service.BackwService;

@Controller
@RequestMapping("/Card")
public class BackMemberBankcardsController {
											//绑卡管理
	@Resource(name="memberBankcardsServiceImpl")
	private BackwService<MemberBankcards> memberBankcardsServiceImpl;
	
	@RequestMapping("/listAll")
	public String listAll(Model model,String qmobile_Phone,String qmember_name,
			String qcard_no,String qcreate_date){
		Map<String,String> map=new HashMap<String,String>();
	    map.put("qmobile_Phone",qmobile_Phone);
	    map.put("qmember_name",qmember_name);
	    map.put("qcard_no",qcard_no);
	    map.put("qcreate_date",qcreate_date);
		List<MemberBankcards> listAll=memberBankcardsServiceImpl.listAll(map);
		model.addAttribute("listAll",listAll);
		model.addAttribute("qmobile_Phone", qmobile_Phone);
		model.addAttribute("qmember_name", qmember_name);
		model.addAttribute("qcard_no", qcard_no);
		model.addAttribute("qcreate_date", qcreate_date);
		return "/Card";
	}
	@RequestMapping("/updatedelflag")
	public String listAll(int id){
		MemberBankcards memberBankcards=memberBankcardsServiceImpl.getById(id);
		memberBankcards.setDelflag(2);
		memberBankcardsServiceImpl.update(memberBankcards);
		return "redirect:/Card/listAll";
	}
}
