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

import com.profit.bean.FeedBack;
import com.profit.bean.Member;
import com.profit.service.FeedbackService;

@Controller
@RequestMapping("/F") 
public class FeedBackController {
	@Autowired
	@Qualifier("feedbackServiceImpl")
	private FeedbackService feedbackServiceImpl;
	
	@RequestMapping("/listall")
	public String listall(Model model){
		List<FeedBack> list=feedbackServiceImpl.listBbinInfo();
		model.addAttribute("Bb",list);
		return "Feedback"; 
	} 
	
	@RequestMapping("/saveF")
	public String saveF(FeedBack feedBack){
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		feedBack.setType("2");
		Member me=new Member();
		me.setId(45);
		feedBack.setMember(me);
		feedbackServiceImpl.saveF(feedBack);
		return "front/frontExploration";
	}
}
