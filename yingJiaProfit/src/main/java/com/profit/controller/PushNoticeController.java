package com.profit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.PushNotice;
import com.profit.service.PushNoticeService;
@Controller
@RequestMapping("/Push")
public class PushNoticeController {

	@Autowired
	@Qualifier("pushNoticeServiceImpl")
	private PushNoticeService pushNoticeServiceImpl;
	@RequestMapping("/toAnnouncements")
	public String toAnnouncements(String title,Model model){
		List<PushNotice> list=pushNoticeServiceImpl.listAllPushNotice(title);
		model.addAttribute("push",list);
		return "Announcements";
	}
	@RequestMapping("/savepushNotice")
	public String savepushNotice(PushNotice pushNotice){
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pushNotice.setCreate_date(date);
		
		pushNoticeServiceImpl.savePushNotice(pushNotice);
		System.out.println(pushNotice.getCreate_date());
		return "redirect:/Push/toAnnouncements";
	}
	@RequestMapping("/listByid")
	public String listByid(int id,Model model){
		System.out.println("123456");
		List<PushNotice> pushNotice=pushNoticeServiceImpl.listByid(id);
		model.addAttribute("ttt",pushNotice);
		return "redirect:/Push/toAnnouncements";
	}
	@RequestMapping("/updatepushNotice")
	public String updatepushNotice(PushNotice pushNotice,String time){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date=dateFormat.parse(time);
			pushNotice.setCreate_date(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Date now=new Date();
		String hehe=dateFormat.format(now);
		
		Date date2 = null;
		try {
			date2 = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		pushNotice.setUpdate_date(date2);
		pushNoticeServiceImpl.updatePushNotice(pushNotice);;
		return "redirect:/Push/toAnnouncements";
	}
}
