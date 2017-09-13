package com.profit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Member;
import com.profit.bean.UserRole;
import com.profit.service.RoleService;
/**
 * 后台管理主页
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
public class ToBackMainPageController {
	
	
	@Autowired
	@Qualifier("memderServiceImpl")
	private RoleService<Member> memderServiceImpl;
	
	@RequestMapping("/admin")
	public String login(){
		return "admin";
	}
	
	//直接跳往角色设置页面
	@RequestMapping("/juese")
	public String asd(){
		return "backRole";
	}
	
	//查询账号后跳转账号管理界面
	@RequestMapping("/Memder")
	public String Memder(Model model){
		List<Member> list=memderServiceImpl.listMemder();
		model.addAttribute("list",list);
		return "backMember";
	}
	
	
	
}
