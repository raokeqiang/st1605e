package com.profit.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.Serviceimpl.BackUsersServiceImpl;
import com.profit.service.BackUsersService;
/**
 * 后台账户管理
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
public class BackMemberController {
	
	@Resource
	private BackUsersService backUsersServiceImpl;
	
	//查询账号后跳转账号管理界面
	@RequestMapping("/Memder")
	public String Memder(Model model){
		List list=this.backUsersServiceImpl.ListUser();
		model.addAttribute("list", list);
		return "backMember";
	}
}
