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
import com.profit.bean.MemberProfitRecord;
import com.profit.bean.MemberPucChargeItem;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SysRechargePriceConfig;
import com.profit.service.ShoppingListService;


@Controller
@RequestMapping("/S")
public class ShoppingListController {


	@Autowired
	@Qualifier("shoppingListServiceImpl")
	private ShoppingListService shoppingListServiceImpl;
	@RequestMapping("/listall")
	public String listall(Model model,String inpoe){
	 List<AwardRecords> list=shoppingListServiceImpl.listAwardRecords();//奖励记录
	 List<Member> list2=shoppingListServiceImpl.listMember(inpoe);//用户交易记录
	 List<MemberAccount> list3=shoppingListServiceImpl.listMemberAccount();//用户统计
	 List<MemberDepositRecord> list4=shoppingListServiceImpl.listMemberDepositRecord();//充值记录
	 List<MemberPucChargeItem> list5=shoppingListServiceImpl.listMemberPucChargeItem();//缴费项目
	 List<MembeWithdrawRecord> list6=shoppingListServiceImpl.listMembeWithdrawRecord();//提现记录
	 List<Subject> list7=shoppingListServiceImpl.listSubject();//投资的详细信息
	 List<Member_tally> list8=shoppingListServiceImpl.listMember_tally();//用户消费记录
	 List<SysRechargePriceConfig> list9=shoppingListServiceImpl.listRechargePriceConfig();//充值面额管理
	 List<MemberProfitRecord> list10 =shoppingListServiceImpl.listMemberProfitRecord();//收益记录
	 model.addAttribute("AwardRecords", list);
	 model.addAttribute("Member", list2);
	 model.addAttribute("MemberAccount", list3);
	 model.addAttribute("MemberDepositRecord", list4);
	 model.addAttribute("MemberPucChargeItem", list5);
	 model.addAttribute("MembeWithdrawRecord", list6);
	 model.addAttribute("Subject", list7);
	 model.addAttribute("Member_tally", list8);
	 model.addAttribute("SysRechargePriceConfig", list9);
	 model.addAttribute("MemberProfitRecord", list10);
		return "ShoppingList";
	}
}
