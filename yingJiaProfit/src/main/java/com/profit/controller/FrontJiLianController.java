package com.profit.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.profit.bean.Member;
import com.profit.bean.MemberBankcards;
import com.profit.service.FrontJiLianService;

@Controller
@RequestMapping("/jilian")
public class FrontJiLianController {

	@Resource
	private FrontJiLianService frontJiLianServiceImpl;
	
	
	@RequestMapping("/sheng")
	public String sheng(Model model ) {
		List list=this.frontJiLianServiceImpl.getSheng();
		model.addAttribute("shengList",list);
		return "frontPersonage/bangka";
	}
	
	@RequestMapping("boundShi")
	@ResponseBody
	public List getBoundShi(HttpServletResponse response,int sid){
		return this.frontJiLianServiceImpl.getShi(sid);
	}
	
	@RequestMapping("boundXiang")
	@ResponseBody
	public List getBoundXiang(HttpServletResponse response,int shid){
		return this.frontJiLianServiceImpl.getxiang(shid);
	}
	
	@RequestMapping("cardBound")
	public String card(HttpServletRequest request,MemberBankcards mb,String province,String shi,String xiang,String identity){
		System.out.println("wodeni");
		Date date=new Date();
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			mb.setCreate_date(sdf.parse(sdf.format(date)));
			mb.setUpdate_date(sdf.parse(sdf.format(date)));
			String province1=this.frontJiLianServiceImpl.getmin(Integer.parseInt(province));
			String shi1=this.frontJiLianServiceImpl.getmin(Integer.parseInt(shi));
			System.out.println(province1+"111---"+shi1);
			mb.setCardaddress(province1+shi1+xiang);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		mb.setDelflag(0);
		Member member=(Member) request.getSession().getAttribute("member");
		member.setIdentity(identity);
		mb.setMember(member);
		this.frontJiLianServiceImpl.saveka(mb);
		this.frontJiLianServiceImpl.updateka(member);
		return "frontPersonage/anquan";
	}
	@RequestMapping("idcardcheck")
	public void idcardcheck(String idcard,HttpServletResponse res){
		List mList=this.frontJiLianServiceImpl.selectka(idcard);
		try {
			PrintWriter pw=res.getWriter();
			if(mList.size()>0){
				pw.print("no");
			}else{
				pw.println("yes");
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@RequestMapping("bankCardCheck")
	public void bankCardCheck(String bankCark,HttpServletResponse res){
		List mList=this.frontJiLianServiceImpl.bankCarkcheck(bankCark);
		try {
			PrintWriter pw=res.getWriter();
			if(mList.size()>0){
				pw.print("no");
			}else{
				pw.println("yes");
			}
			pw.flush();
			pw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
