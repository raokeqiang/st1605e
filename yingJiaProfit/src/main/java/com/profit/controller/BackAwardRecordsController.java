package com.profit.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.AwardRecords;
import com.profit.bean.Range;
import com.profit.service.BackServicetwo;

@Controller
@RequestMapping("/Invite")
public class BackAwardRecordsController {
										//邀请管理
	@Resource(name="awardRecordsServiceImpl")
	private BackServicetwo<AwardRecords> awardRecordsServiceImpl;
	
	@RequestMapping("/listAll")
	public String listAll(Model model,String qmember_name,String qmobile_Phone,
		String qinvitationCode,String qinvitedCode,String qenroll,String qinvest){
		Map map=new HashMap();
	    map.put("qmember_name",qmember_name );
	    map.put("qmobile_Phone",qmobile_Phone );
	    map.put("qinvitationCode",qinvitationCode );
	    map.put("qinvitedCode",qinvitedCode );
	    map.put("qenroll",qenroll );
	    map.put("qinvest",qinvest );
		List<Range> listAll=awardRecordsServiceImpl.listRange(map);
		model.addAttribute("qmember_name",qmember_name );
		model.addAttribute("qmobile_Phone",qmobile_Phone );
		model.addAttribute("qinvitationCode",qinvitationCode );
		model.addAttribute("qinvitedCode",qinvitedCode );
		model.addAttribute("qenroll",qenroll );
		model.addAttribute("qinvest",qinvest );
		model.addAttribute("listAll",listAll);
		return "/Invite";
	}
	
	@RequestMapping("/Rewardslog")
	public String Rewardslog(Model model,String phone){
		Map<String,String> map=new HashMap<String,String>();
		map.put("phone",phone);
		System.out.println(phone);
		List<AwardRecords> awardRecordsList=awardRecordsServiceImpl.listAll(map);
		System.out.println("-------------213434");
		model.addAttribute("awardRecordsList", awardRecordsList);
		return "/Invitelog";
	}
}
