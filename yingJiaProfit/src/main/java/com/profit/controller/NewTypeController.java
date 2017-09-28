package com.profit.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.NewsType;
import com.profit.service.NewsService;
import com.profit.service.NewsTypeService;

@Controller
@RequestMapping("/T")
public class NewTypeController {
	@Autowired
	@Qualifier("newsTypeServiceImpl")
	private NewsTypeService newsTypeServiceImpl;
	
	@RequestMapping("/listnewsType")
	public String listnewsType(Model model){
		List<NewsType> list=newsTypeServiceImpl.listType();
		model.addAttribute("types", list);
		return "information_classification";
	}
	@RequestMapping("/updatenewstype")
	public String updatenewstype(NewsType newstype,String Time){
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		newstype.setAddTime(date);
		newsTypeServiceImpl.updateType(newstype);
		return "redirect:/T/listnewsType";
	}
	@RequestMapping("/savetype")
	public String savetype(NewsType newstype){
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		newstype.setAddTime(date);
		newsTypeServiceImpl.savetype(newstype);
		return "redirect:/T/listnewsType";
	}
}
