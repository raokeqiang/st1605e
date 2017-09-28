package com.profit.controller;

import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/show")
public class ShowFrontController {

	//显示主页上部内容
	@RequestMapping("/frontTopIframe")
	public String toTop(){
		return "front/frontTopIframe";
	}
	//显示首页中部内容
	@RequestMapping("/frontMiddleIframe")
	public String toMiddle(){
		return "front/frontMiddleIframe";
	}
	//进入前台首页 页面
	@RequestMapping("/frontHome")
	public String Home(){
		return "front/frontHome";
	}
	//进入登陆界面
	@RequestMapping("/frontIframeLogin")
	public String toLogin(){
		return "front/frontIframeLogin";
	}
	//进入网上体验中心界面
	@RequestMapping("/frontExploration")
	public String toExploration(){
		return "front/frontExploration";
	}
	//进入商学院界面
	@RequestMapping("/frontCollege")
	public String toCollege(){
		return "front/frontCollege";
	}
	//进入新闻中心页面
	@RequestMapping("/frontJournalism")
	public String toJournalism(){
		return "front/frontJournalism";
	}
	//进入下载中心界面
	@RequestMapping("/frontLoad")
	public String  toLoad(){
		return "front/frontLoad";
	}
	//进入产品中心界面
	@RequestMapping("/frontProduct")
	public String  toProduct(){
		return "front/frontProduct";
	}
	//进入投研中心界面
	@RequestMapping("/frontStudy")
	public String  toStudy(){
		return "front/frontStudy";
	}
	@RequestMapping("/xiugai")
	public String  xiugai(){
		return "front/xiugaimima";
	}
	@RequestMapping("/tikuan")
	public String  tikuan(){
		return "front/tikuanmima";
	}
}
