package com.profit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfitController {

	//jjwwgg
	@RequestMapping("/index")//主页
	public String index(){
		return "admin";
	}
	@RequestMapping("/menus1")//固收类
	public String menus1(){
		return "menus1";
	}
	@RequestMapping("/cwtj")//财务统计
	public String cwtj(){
		return "cwtj";
	}
	@RequestMapping("/gggl")//公告管理
	public String gggl(){
		return "gggl";
	}
	@RequestMapping("/yhzh")//用户综合
	public String yhzh(){
		return "yhzh";
	}
	@RequestMapping("/yjfk")//意见反馈
	public String yjfk(){
		return "yjfk";
	}
	@RequestMapping("/jfjl")//缴费记录
	public String jfjl(){
		return "jfjl";
	}
	@RequestMapping("/zxfl")//咨询分类
	public String zxfl(){
		return "zxfl";
	}
	@RequestMapping("/zxgl")//缴费记录
	public String zxgl(){
		return "zxgl";
	}
	@RequestMapping("/menus7")  //理财师审核
	public String menus7(){
		return "menus7";
	}
	@RequestMapping("/menus8")  //绑卡管理
	public String menus8(){
		return "menus8";
	}
	@RequestMapping("/menus9")  //付息计划
	public String menus9(){
		return "menus9";
	}
	@RequestMapping("/menus10")  //充值管理
	public String menus10(){
		return "menus10";
	}
	@RequestMapping("/menus11")  //提现管理
	public String menus11(){
		return "menus11";
	}
	@RequestMapping("/menus12")  //邀请管理
	public String menus12(){
		return "menus12";
	}
	@RequestMapping("/menus13")  //账号管理
	public String menus13(){
		return "menus13";
	}
}
