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

import com.profit.bean.News;
import com.profit.bean.NewsType;
import com.profit.service.NewsService;
import com.profit.service.NewsTypeService;

@Controller
@RequestMapping("/N")
public class NewsController {
	@Autowired
	@Qualifier("newsServiceImpl")
	private NewsService newsServiceImpl;
	@Autowired
	@Qualifier("newsTypeServiceImpl")
	private NewsTypeService newsTypeServiceImpl;
	@RequestMapping("/listnews")
	public String listnews(Model model,String title,String typeid){
		List<News> list=newsServiceImpl.listnews(title, typeid);
		model.addAttribute("news", list);
		List<NewsType> list2=newsTypeServiceImpl.listType();
		model.addAttribute("types", list2);
		return "Information_Management"; 
	}
	
	@RequestMapping("/savenews")
	public String savenews(News news){
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		news.setAddTie(date);
		newsServiceImpl.saveews(news);
		return "redirect:/N/listnews";
	}
	@RequestMapping("/updatenews")
	public String updatenews(News news,String time){
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date date = null;
		try {
			date=dateFormat.parse(time);
			news.setAddTie(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		newsServiceImpl.update(news);
		return "redirect:/N/listnews";
	}
	@RequestMapping("/delect")
	public String delect(News news){
		newsServiceImpl.delete(news);
		return "redirect:/N/listnews";
	}
}
