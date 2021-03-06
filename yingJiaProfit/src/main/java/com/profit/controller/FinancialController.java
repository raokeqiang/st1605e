package com.profit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.AwardRecords;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.service.FinancialService;


@Controller
@RequestMapping("/Fin")
public class FinancialController {

	@Autowired
	@Qualifier("financialServiceImpl")
	private FinancialService financialServiceImpl;
	@RequestMapping("/listall")
	public String listall(Model model,String iphone,String start,String type,String zhifu){
		if(iphone==null||"".equals(iphone)){
			iphone="0";
		}
		boolean tf=financialServiceImpl.tf(iphone);
		if(tf){
			
		}else{
			iphone="0";
		}
		List<AwardRecords>       a1=financialServiceImpl.lsa(iphone, start);
		List<Member>              a2=financialServiceImpl.lsm(iphone);
		List<MemberAccount>      a3=financialServiceImpl.lsma(iphone, start);
		List<MemberDepositRecord > a4=financialServiceImpl.lsmdr(iphone, start);
		List<Member_tally> a5=financialServiceImpl.lsmt(iphone, start);
		List<MembeWithdrawRecord> a6=financialServiceImpl.lsmw(iphone, start);
		List<MemberTradeRecord> a7=financialServiceImpl.lst(iphone, start,type,zhifu);
		model.addAttribute("a1",a1 );//奖励记录表
		model.addAttribute("a2",a2 );//个人信息表
		model.addAttribute("a3",a3 );//余额表
		model.addAttribute("a4",a4 );//充值记录表
		model.addAttribute("a5",a5 );//生活消费
		model.addAttribute("a6",a6 );//提现记录表
		model.addAttribute("a7",a7 );//交易记录表
		return "YjHow";
	}
}
