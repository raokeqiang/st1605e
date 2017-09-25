package com.profit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.UserRole;
import com.profit.bean.Users;
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
		List rlist=this.backUsersServiceImpl.rlistUser();
		model.addAttribute("list", list);
		model.addAttribute("rlist", rlist);
		return "backMember";
	}
	
	@RequestMapping("/save")
	public String save(Users users,int rid){
		Date now =new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe = dateFormat.format(now);
		Date date=null;
		try {
			date=dateFormat.parse(hehe);
		} catch (ParseException e){
			e.printStackTrace();
		}
		users.setCreate_date(date);
		users.setUpdate_date(date);
		users.setStatus(0);
		users.setSalt("javamd");
		users.setDel_flag(0);
		UserRole userRole=	this.backUsersServiceImpl.selectRo(rid);
		users.setUserRole(userRole);
		this.backUsersServiceImpl.saveUsers(users);
		return "redirect:/admin/Memder";
	}
}
