package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Member;
import com.profit.service.BackwService;

@Controller
@RequestMapping("/Member")
public class BackMemberController {
									//用户管理
	@Resource(name="memberServiceImpl")
	private BackwService<Member> memberService;
	
	@RequestMapping("/listAll")
	public String listAll(Model model,String qname,String qmember_name,
		String qmobile_Phone, String qinvitationCode,String qcreate_date){
		Map<String,String> map=new HashMap<String,String>();
	    map.put("qname",qname);
	    map.put("qmember_name",qmember_name);
	    map.put("qmobile_Phone",qmobile_Phone);
	    map.put("qinvitationCode",qinvitationCode);
	    map.put("qcreate_date",qcreate_date);
		List<Member> listAll=memberService.listAll(map);
		model.addAttribute("listAll",listAll);
		model.addAttribute("qname", qname);
		model.addAttribute("qmember_name", qmember_name);
		model.addAttribute("qmobile_Phone", qmobile_Phone);
		model.addAttribute("qinvitationCode", qinvitationCode);
		model.addAttribute("qcreate_date", qcreate_date);
		return "/Member";
	}
	@RequestMapping("/MemberDetails")
	public String memberDetails(Model model,int id){
		Member member=memberService.getById(id);
		model.addAttribute("member",member);
		return "MemberDetails";
	} 
}
