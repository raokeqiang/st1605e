package com.profit.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Member;
import com.profit.service.BackwService;

@Controller
@RequestMapping("/Manage")
public class BackManageController {
									//理财师管理
	@Resource(name="memberServiceImpl")
	private BackwService<Member> memberService;
	
	@RequestMapping("/listAll")
	public String listAll(Model model){
//		Map<String,String> map=new HashMap<String,String>();
//		List<Member> listAll=memberService.listAll(map);
//		model.addAttribute("listAll",listAll);
		return "Manage";
	}
//	@RequestMapping("/MemberDetails")
//	public String memberDetails(Model model,int id){
//		Member member=memberService.getById(id);
//		model.addAttribute("member",member);
//		return "MemberDetails";
//	} 
}
