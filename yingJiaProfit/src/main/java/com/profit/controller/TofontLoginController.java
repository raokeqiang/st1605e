package com.profit.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profit.bean.Member;
import com.profit.service.FrontLoginService;

@Controller
@RequestMapping("/toFrontLogin")
public class TofontLoginController {
	
	@Resource
	private FrontLoginService FrontLoginServiceImpl;
	
	
	//进入前台登陆界面
	@RequestMapping("/login")
	public String userLogin(){
		return "front/frontIframeLogin";
	}
	
	@ResponseBody
	@RequestMapping("/loginCheck")
	public boolean checkUserInfo(String mobilePhone,String password,HttpSession session){
		
		boolean bool=this.FrontLoginServiceImpl.checkLogin(mobilePhone, password);
		if(bool==true){
			Member member=this.FrontLoginServiceImpl.getMemberByPhone(mobilePhone);
			session.setAttribute("member", member);
			return bool;
		}
		return false;
	}
	//退出登录清除Session
	@RequestMapping("/logout")
	public String logout(String url,HttpSession session){
		session.setAttribute("member", null);//清除页面session
		return "front/frontIframeLogin";
	}
	

}
