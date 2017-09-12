package com.profit.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 后台管理主页
 * @author Administrator
 *
 */
@Controller
@RequestMapping("/admin")
public class ToBackMainPageController {

	@RequestMapping("/admin")
	public String login(){
		return "admin";
	}
}
