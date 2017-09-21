package com.profit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profit.Cry.CryptographyUtil;
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
		
		boolean bool=this.FrontLoginServiceImpl.checkLogin(mobilePhone, CryptographyUtil.md5(password, "javamd"));
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
	
	
	//注册手机号校验
	@RequestMapping("/phone")
	public String phone(String phone,HttpServletResponse response){
		System.out.println("手机号校验");
		PrintWriter pw;
		Member member =this.FrontLoginServiceImpl.getMemberByPhone(phone);
		try{
			pw=response.getWriter();
			if(member!=null){
				pw.print("no");
				pw.flush();
				pw.close();
			}else{
				pw.print("yes");
			}
		} catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}
	//注册提交
	@RequestMapping("/zhuce")
	public void zhuce(Member member,HttpServletResponse response){
		member.setIdentity("");
		SimpleDateFormat df=new SimpleDateFormat("yyyy-mm-dd HH:mm:ss");
		String date=df.format(new Date());
		System.out.println("注册");
		try {
			PrintWriter pw=response.getWriter();
			member.setCreate_date(df.parse(date));
			member.setUpdate_date(df.parse(date));
			member.setSalt("javamd");
			member.setPassword(CryptographyUtil.md5(member.getPassword(), "javamd"));
			this.FrontLoginServiceImpl.saveMember(member);
			pw.print("success!!!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
