package com.profit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.Serviceimpl.RoleServiceImpl;
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
	@Qualifier("roleServiceImpl")
	private RoleService roleServiceImpl;
	
	@RequestMapping("/admin")
	public String login(){
		return "admin";
	}
	
	//直接跳往角色设置页面
	@RequestMapping("/juese")
	public String asd(){
		return "backRole";
	}
	
	//查询内容后跳往角色设置界面
	@RequestMapping("/juese1")
	public String listAll(Model model){
		List<UserRole> list=roleServiceImpl.listRole();
		model.addAttribute("list",list);
		return "backRole";
	}
	
	
	
}
