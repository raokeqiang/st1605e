package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.profit.bean.MemberTradeRecord;
import com.profit.service.MemberTradeRecordService;


@Controller
@RequestMapping("/wallet")
public class MemberTradeRecordWalletHouController {
	@Autowired
	@Qualifier("memberTradeRecordWalletServiceImpl")
	private MemberTradeRecordService memberTradeRecordWalletServiceImpl;
	
	@RequestMapping("/listAll")
	public String listAll(Model model,@RequestParam(required=false)String qtrade_no ,String qmobile_Phone ,String qtrade_type ,Integer qtrade_status){
		if(qtrade_type!=null && qtrade_type.equals("-1")){
			qtrade_type=null;
		}
		if(qtrade_status!=null && qtrade_status==-1){
			qtrade_status=null;
		}
		
		Map map=new HashMap();
		map.put("qtrade_no", qtrade_no);
		map.put("qmobile_Phone", qmobile_Phone);
		map.put("qtrade_type", qtrade_type);
		map.put("qtrade_status", qtrade_status);
		
		List<MemberTradeRecord> memberTradeRecordList=memberTradeRecordWalletServiceImpl.listAll(map);
		model.addAttribute("memberTradeRecordList", memberTradeRecordList);
		
		model.addAttribute("qtrade_no", qtrade_no);
		model.addAttribute("qmobile_Phone", qmobile_Phone);
		model.addAttribute("qtrade_type", qtrade_type);
		model.addAttribute("qtrade_status", qtrade_status);
		return "wallet";
	}
}
