package com.profit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.PushNotice;
import com.profit.service.PushNoticeService;
@Controller
@RequestMapping("/Push")
public class PushNoticeController {

	@Autowired
	private PushNoticeService pushNoticeService;
	@RequestMapping("/toAnnouncements")
	public String toAnnouncements(String title,Model model){
		List<PushNotice> list=pushNoticeService.listAllPushNotice(title);
		model.addAttribute("push",list);
		return "Announcements";
	}
}
