package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.FinanciaPlanner;
import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.service.BackwService;

@Controller
@RequestMapping("/Withdraw")
public class BackMembeWithdrawRecordController {
												//提现管理
	@Resource(name="memberWithdrawRecordServiceImpl")
	private BackwService<MembeWithdrawRecord> memberWithdrawRecordServiceImpl;
	@Resource(name="memberAccountServiceImpl")
	private BackwService<MemberAccount> memberAccountServiceImpl;
	@Resource(name="financiaPlannerServiceImpl")
	private BackwService<FinanciaPlanner> financiaPlannerServiceImpl;
	@Resource(name="subjectPurchaseRecordServiceImpl")
	private BackwService<SubjectPurchaseRecord> subjectPurchaseRecordServiceImpl;
	@Resource(name="memberDepositRecordServiceImpl")
	private BackwService<MemberDepositRecord> memberDepositRecordServiceImpl;
	@Resource(name="memberTradeRecordServiceImpl")
	private BackwService<MemberTradeRecord> memberTradeRecordServiceImpl;
	
	@RequestMapping("/listAll")
	public String listAll(Model model,String qmember_name,String qmobile_Phone,
			String qbank_card,String qstatus,String qcreate_date){
		Map<String,String> map=new HashMap<String,String>();
	    map.put("qmember_name",qmember_name);
	    map.put("qmobile_Phone",qmobile_Phone);
	    map.put("qbank_card",qbank_card);
	    map.put("qstatus",qstatus);
	    map.put("qcreate_date",qcreate_date);
		List<MembeWithdrawRecord> listAll=memberWithdrawRecordServiceImpl.listAll(map);
		model.addAttribute("listAll",listAll);
		model.addAttribute("qmember_name",qmember_name);
		model.addAttribute("qmobile_Phone",qmobile_Phone);
		model.addAttribute("qbank_card", qbank_card);
		model.addAttribute("qstatus", qstatus);
		model.addAttribute("qcreate_date", qcreate_date);
		return "/Withdraw";
	}
	@RequestMapping("/Accdetails")
	public String Accdetails(Model model,int id,int member_id){
		MembeWithdrawRecord membeWithdrawRecord=memberWithdrawRecordServiceImpl.getById(id);
		
		Map map=new HashMap();
		map.put("member_id",member_id);
		
		List<MemberAccount> list1= memberAccountServiceImpl.listAll(map);
		MemberAccount memberAccount=(MemberAccount)list1.get(0);
		
		List<FinanciaPlanner> list2= financiaPlannerServiceImpl.listAll(map);
		 if(list2.size()==0){
			 model.addAttribute("index",0);
		}else{
			 model.addAttribute("index",1);
			 FinanciaPlanner financiaPlanner=(FinanciaPlanner)list2.get(0);
			 model.addAttribute("financiaPlanner", financiaPlanner);
		}
		List<SubjectPurchaseRecord> list3= subjectPurchaseRecordServiceImpl.listAll(map);
		SubjectPurchaseRecord subjectPurchaseRecord=(SubjectPurchaseRecord)list3.get(0);
		
		
		List<MemberDepositRecord> list4= memberDepositRecordServiceImpl.listAll(map);
		MemberDepositRecord memberDepositRecord=(MemberDepositRecord)list4.get(0);
		
		List<MemberTradeRecord> list5= memberTradeRecordServiceImpl.listAll(map);
		MemberTradeRecord memberTradeRecord=(MemberTradeRecord)list5.get(0);
		
		model.addAttribute("membeWithdrawRecord", membeWithdrawRecord);
		model.addAttribute("memberAccount", memberAccount);
		model.addAttribute("subjectPurchaseRecord", subjectPurchaseRecord);
		model.addAttribute("memberDepositRecord", memberDepositRecord);
		model.addAttribute("memberTradeRecord", memberTradeRecord);
		return "/Accdetails";
	}
	@RequestMapping("/Audit")
	public String Audit(Model model,int id){
	   MembeWithdrawRecord membeWithdrawRecord=memberWithdrawRecordServiceImpl.getById(id);
	     membeWithdrawRecord.setStatus(1);
	    memberWithdrawRecordServiceImpl.update(membeWithdrawRecord);
		return "redirect:/Withdraw/listAll";
		}
	@RequestMapping("/Thaw")
	public String Thaw(Model model,int id){
		MembeWithdrawRecord membeWithdrawRecord=memberWithdrawRecordServiceImpl.getById(id);
	     membeWithdrawRecord.setStatus(5);
	    memberWithdrawRecordServiceImpl.update(membeWithdrawRecord);
		return "redirect:/Withdraw/listAll";
		}
}
