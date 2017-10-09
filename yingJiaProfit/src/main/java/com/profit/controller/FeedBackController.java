package com.profit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@RequestMapping("/tu")
	public String tu(){
		return "front/frontExploration"; 
	} 
	@RequestMapping("/saveF")
	public String saveF(FeedBack feedBack,HttpServletRequest requst,HttpServletResponse response) throws IOException{
		PrintWriter pw=response.getWriter();
//		Member m=(Member) requst.getSession().getAttribute("member");
//		if(){
//			pw.print("wu");
//			return null;
//		}
//		else 
			if(feedBack.getContent()==null||("").equals(feedBack.getContent())){
				pw.print("no");
			return null;
		}else if(feedBack.getIphone().length()!=11){
				pw.print("ll");
			return null;
		}else{
		Date now=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String hehe=dateFormat.format(now);
		
		Date date = null;
		try {
			date = dateFormat.parse(hehe);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		feedBack.setCreate_date(date);
		feedBack.setType("2");
		Member me=new Member();
		me.setId(45);
		feedBack.setMember(me);
		feedbackServiceImpl.saveF(feedBack);
		pw.print("yes");
		return null;
	}
}
}