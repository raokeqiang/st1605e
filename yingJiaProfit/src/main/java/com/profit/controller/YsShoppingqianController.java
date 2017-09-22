package com.profit.controller;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.jws.WebParam.Mode;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberBankcards;
import com.profit.bean.MemberProfitRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.service.YsMemberCardService;
import com.profit.service.YsSubjectService;

@Controller
@RequestMapping("/shopping")
public class YsShoppingqianController {
	@Autowired
	@Qualifier("ysSubjectServiceImpl")
	private YsSubjectService subjectService;
	@Autowired
	@Qualifier("ysMemberCardServiceImpl")
	private YsMemberCardService memberCardService;

	@RequestMapping("/toBuy")
	public String shopping(Model model, int id, HttpSession session) {
		Map map = new HashMap<>();
		//Member me = null;
		Object object = session.getAttribute("member");
		if (object != null) {
			Subject sub = subjectService.getById(id);
			List<Subject> list = subjectService.listSubject(map);
			model.addAttribute("sub", sub);
			model.addAttribute("list", list);
			// 显示账户余额                                                                                                                                    
			// 先取出登录时会员的id
			//Object object = session.getAttribute("member");
			if (object != null) {
				Member member = (Member) object;
				int memberId = member.getId();
				System.out.println("memeberId:"+memberId);
				MemberAccount memberAccount = memberCardService.memberAccountById(memberId);
				System.out.println("account:"+memberAccount.getUseable_balance());
				model.addAttribute("memberAccount", memberAccount);
				// 判断绑卡member_bankcards(成员银联表)和member关联memberId 关联
				MemberBankcards memberBankcards = memberCardService.memberCardById(memberId);
				model.addAttribute("memberBankcards", memberBankcards);
				
                return "front/frontShopping";
             }
		}
		return "front/frontIframeLogin";
	}
	
	//当点击确认购买之后，表的数据会发生改变
	//跳到购买的页面mytext页面上的起头金额amountYuE//页面上的余额
		@RequestMapping("/goBuy")
		public String goBuy(String subjectId,String amountYuE,String mytext,Model model,HttpSession session,
		MemberProfitRecord memberProfitRecord,MemberTradeRecord memberTradeRecord,
		Member_tally member_tally,SubjectPurchaseRecord subjectPurchaseRecord,HttpServletRequest request){
		//从session 获取member信息
		String text=request.getParameter("mytext");
		String amount=request.getParameter("amountYuE");
			Object object=session.getAttribute("member");
			if (object!=null) {
				Member member=(Member) object;
			    int meberId=member.getId();
			    Date sysDate=(new Date());
			    //流水号
				String sysDateAndRandom=new SimpleDateFormat("yyyyMMddHHmmss").format(new Date())+(int)(Math.random()*9)+(int)(Math.random()*9);
				Calendar now=Calendar.getInstance();
				//subject表
				Subject subject=this.memberCardService.getSubjectById(Integer.parseInt(subjectId));
				subject.setBought(subject.getBought()+1);
				subject.setAmount(subject.getAmount()+Integer.parseInt(mytext));
				this.memberCardService.upsubject(subject);
				subject=this.memberCardService.getSubjectById(Integer.valueOf(subjectId));
				//结算利息
				double interest=((((Integer.parseInt(mytext)*(subject.getYear_rate()+1))/100)/365)*(subject.getPeriod()));
			   //成员账户表
				MemberAccount memberAccount=this.memberCardService.memberAccountById(meberId);
				memberAccount.setUseable_balance(Integer.parseInt(amountYuE)-Integer.parseInt(mytext));
				memberAccount.setUpdate_date(sysDate);
				memberAccount.setInvest_amount(Integer.parseInt(mytext)+memberAccount.getInvest_amount());
				memberAccount.setMember(member);
				this.memberCardService.updatememberAccount(memberAccount);
				//操作成员利润表
				memberProfitRecord.setMember(member);
				memberProfitRecord.setSubject(subject);
				memberProfitRecord.setSerial_number(sysDateAndRandom);
				memberProfitRecord.setType(0);
				memberProfitRecord.setAmount(interest);
				memberProfitRecord.setDelflag(0);
				memberProfitRecord.setCreate_date(sysDate);
				memberProfitRecord.setUpdate_date(sysDate);
				memberProfitRecord.setComment("购买了"+subject.getName());
				memberProfitRecord.setProfit_year(now.get(Calendar.YEAR));
				memberProfitRecord.setProfit_month(now.get(Calendar.MONTH+1));
				memberProfitRecord.setProfit_day(now.get(Calendar.DAY_OF_MONTH));
				this.memberCardService.saveMemberProfitRecord(memberProfitRecord);
				//操作交易记录表
				memberTradeRecord.setMember(member);
				memberTradeRecord.setTrade_no(sysDateAndRandom);
				memberTradeRecord.setTrade_name("购买了"+subject.getName());
				memberTradeRecord.setCounterpart("盈+理财公司");
				memberTradeRecord.setAmount(Integer.parseInt(mytext));
				memberTradeRecord.setTrade_type(subject.getName());
				memberTradeRecord.setFund_flow(0);
				memberTradeRecord.setTrade_status(0);
				memberTradeRecord.setExt_field_1("扩展1");
				memberTradeRecord.setExt_field_2("扩展2");
				memberTradeRecord.setExt_field_3("扩展3");
				memberTradeRecord.setCreate_date(sysDate);
				memberTradeRecord.setUpdate_date(sysDate);
				this.memberCardService.saveMemberTradeRecord(memberTradeRecord);
				//操作记账表
				member_tally.setMember(member);
				member_tally.setType_id(1);
				member_tally.setType_name("A标");
				member_tally.setAmount(Integer.parseInt(mytext));
				member_tally.setPay_date(sysDate);
				member_tally.setCreate_date(sysDate);
				this.memberCardService.saveMember_tally(member_tally);
				//标的购买表
				subjectPurchaseRecord.setSubject(subject);
			   subjectPurchaseRecord.setMember(member);
			//subjectPurchaseRecord.setSerial_number(sysDate);
				subjectPurchaseRecord.setAmount(Integer.parseInt(mytext));
				subjectPurchaseRecord.setDeal_id("");
				subjectPurchaseRecord.setDelflag(0);
				subjectPurchaseRecord.setCreate_date(sysDate);
				subjectPurchaseRecord.setUpdate_date(sysDate);
				subjectPurchaseRecord.setInterset(interest);
				subjectPurchaseRecord.setIspayment(1);
				subjectPurchaseRecord.setPay_interest_times(1);
				subjectPurchaseRecord.setLast_profit_day(Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())));
				subjectPurchaseRecord.setBonus_info("无");
				this.memberCardService.saveSubjectPurchaseRecord(subjectPurchaseRecord);
			List<SubjectPurchaseRecord>list=this.memberCardService.listSubjectPurchaseRecord(Integer.valueOf(subjectId));
		//购买成功后跳到个人信息页面,同时显示改变表的信息
//		 }
			return "redirect:/shopping/showshop";
			}else{
				return "redirect:/shopping/toBuy";
			}
			
			
		}
		//购买成功后，页面显示
		@RequestMapping("/showshop")
		public String showshop(Model model){
		List<SubjectPurchaseRecord>list=memberCardService.listSubpurchaseRecord();
		model.addAttribute("list",list);
			return "frontPersonage/touzi";
		}
	
	// 绑定银行卡，member_bankcards(成员银联表)和member关联
	@RequestMapping("/memberCard")
	public String memberCard() {
		return "frontPersonage/bangka";
	}

// 绑卡，将数据绑到银行卡中
	@RequestMapping("/savememberCard")
	public String savememberCard(MemberBankcards memberCard, HttpServletRequest request) {
		// 从页面上获取值
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String type = request.getParameter("type");
		String card_no = request.getParameter("card_no");
		String cardaddress = request.getParameter("cardress");
		System.out.println("名字:"+name+"身份证:"+identity+"开户银行"+type+"卡号"+card_no+"地址:"+cardaddress);
        memberCard.setCard_no(card_no);
		memberCard.setCardaddress(cardaddress);
		memberCard.setType(type);
		memberCard.getMember().setIdentity(identity);
		memberCard.getMember().setName(name);
		memberCardService.saveMemberCard(memberCard);
		return "front/frontShopping";
	}

}
