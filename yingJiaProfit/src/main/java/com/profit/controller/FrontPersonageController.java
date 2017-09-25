package com.profit.controller;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.mail.Session;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.MembeWithdrawRecord;
import com.profit.bean.Member;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.SubjectBbinPurchassRecord;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.service.BackwService;

@Controller
@RequestMapping("/toFrontPersonage")
public class FrontPersonageController {
	
	@Resource(name="subjectPurchaseRecordServiceImpl")         //标的订单收益
	private BackwService<SubjectPurchaseRecord> subjectPurchaseRecordServiceImpl;
	
	@Resource(name="memberDepositRecordServiceImpl")         //充值管理
	private BackwService<MemberDepositRecord> memberDepositRecordServiceImpl;
	@Resource(name="memberWithdrawRecordServiceImpl")         //提现管理
	private BackwService<MembeWithdrawRecord> memberWithdrawRecordServiceImpl;
	@Resource(name="subjectBbinPurchassRecordServiceImpl")    //体验金
	private BackwService<SubjectBbinPurchassRecord> subjectBbinPurchassRecordServiceImpl;
		@RequestMapping("/touzi")
		public String touzi(Model model,Map map,HttpSession session){
			Member member=(Member)session.getAttribute("member");
			map.put("member_id", member.getId());
			List<SubjectPurchaseRecord> list= subjectPurchaseRecordServiceImpl.listAll(map);
			model.addAttribute("touZiCnt", list.size());
			model.addAttribute("list", list);
			return "/frontPersonage/touzi";
		}
		@RequestMapping("/shouyi")
		public String FrontPersonage(Model model,Map map,HttpSession session){
			Member member=(Member)session.getAttribute("member");
			map.put("member_id", member.getId());
			List<SubjectPurchaseRecord> listAll=subjectPurchaseRecordServiceImpl.listAll(map);
			model.addAttribute("listAll", listAll);
			return "/frontPersonage/ShouYi";
		}
		
		@RequestMapping("/chongzhi")
		public String chongzhi(Model model,Map map,HttpSession session){
			Member member=(Member)session.getAttribute("member");
			map.put("member_id", member.getId());
			List<MemberDepositRecord> listAll=memberDepositRecordServiceImpl.listAll(map);
			model.addAttribute("listAll", listAll);
			return "/frontPersonage/chongzhi";
		}
		
		@RequestMapping("/tikuan")
		public String tixian(Model model,Map map,HttpSession session){
			Member member=(Member)session.getAttribute("member");
			map.put("member_id", member.getId());
			List<MembeWithdrawRecord> listAll=memberWithdrawRecordServiceImpl.listAll(map);
			model.addAttribute("listAll", listAll);
			return "/frontPersonage/tikuan";
		}
		@RequestMapping("/tiyanjin")
		public String tiyanjin(Model model,Map map,HttpSession session){
			 Member member=(Member)session.getAttribute("member");
			 map.put("member_id",member.getId() );
		     List<SubjectBbinPurchassRecord> listAll=subjectBbinPurchassRecordServiceImpl.listAll(map);
		     model.addAttribute("listAll",listAll);
			return "/frontPersonage/tiyanjin";
		}
	
		@RequestMapping("/anquan")
		public String anquan(){
			return "/frontPersonage/anquan";
		}
		@RequestMapping("/woyaotikuan")
		public String woyaotikuan(){
			return "/frontPersonage/woyaotikuan";
		}
		@RequestMapping("/bangka")
		public String bangka(){
			return "/frontPersonage/bangka";
		}
		
		//购买页面
		@RequestMapping("/shopping")
		public String shopping(){
			return "/front/frontShopping";
		}
		//注册页面
		@RequestMapping("/zhuce")
		public String zhuce(){
			return "/front/frontZhuCe";
		}
		
		
	}
