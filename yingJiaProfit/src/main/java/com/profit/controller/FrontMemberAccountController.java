package com.profit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.MemberAccount;
import com.profit.service.FrontMemberAccountService;

@Controller
@RequestMapping("/MemberAccount")
public class FrontMemberAccountController {
	
	@Resource
	private FrontMemberAccountService frontMemberAccountServiceImpl;
	
	@RequestMapping("/select")
	public String select(int member_id,HttpServletRequest request,HttpSession session){
		MemberAccount mA=this.frontMemberAccountServiceImpl.selectMA(member_id);
		session.setAttribute("memberAccount", mA);
		return "redirect:/toFrontPersonage/shouyi";
		
	}
}
