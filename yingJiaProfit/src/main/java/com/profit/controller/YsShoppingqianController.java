package com.profit.controller;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberBankcards;
import com.profit.bean.MemberDepositRecord;
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
				System.out.println("wang"+interest);
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

			     subjectPurchaseRecord.setSerial_number(sysDateAndRandom);

				subjectPurchaseRecord.setAmount(Integer.parseInt(mytext));
				subjectPurchaseRecord.setDeal_id("");
				subjectPurchaseRecord.setDelflag(0);
				subjectPurchaseRecord.setCreate_date(sysDate);
				subjectPurchaseRecord.setUpdate_date(sysDate);
				subjectPurchaseRecord.setInterest(interest);
				subjectPurchaseRecord.setIspayment(1);
				subjectPurchaseRecord.setPay_interest_times(1);
				subjectPurchaseRecord.setLast_profit_day(Integer.parseInt(new SimpleDateFormat("yyyyMMdd").format(new Date())));
				subjectPurchaseRecord.setBonus_info("无");
				this.memberCardService.saveSubjectPurchaseRecord(subjectPurchaseRecord);
			List<SubjectPurchaseRecord>list=this.memberCardService.listSubjectPurchaseRecord(Integer.valueOf(subjectId));
		//购买成功后跳到个人信息页面,同时显示改变表的信息
//		 }
			return "redirect:/toFrontPersonage/touzi";
			}else{
				return "redirect:/shopping/toBuy";
			}
}
		
//此方法是判断用户是否绑卡
//		@RequestMapping("/purched")
//		public String purched(int  subjectId,Model model,HttpSession session){
//			//先取出用户的id
//			Member member=(Member)session.getAttribute("member");
//			if(member!=null){
//				MemberAccount memberAccount=memberCardService.memberAccountById(member.getId());
//				//根据登录人判断是否绑定银行卡
//				List<MemberBankcards>memberBankcards=memberCardService.listMemberCard(member.getId());
//				model.addAttribute("memberAccount", memberAccount);
//				model.addAttribute("memberBankcards", memberBankcards);
//			}
//			Subject subject=memberCardService.getSubjectById(subjectId);
//			session.setAttribute("subject", subject);
//			return "frontPersonage/touzi";
//		}

// 绑卡，将数据绑到银行卡中
	@RequestMapping("/savememberCard")
	public String savememberCard(MemberBankcards memberCard, HttpServletRequest request,HttpSession session) {
	Member member	=(Member) session.getAttribute("member");
		// 从页面上获取值
		String name = request.getParameter("name");
		String identity = request.getParameter("identity");
		String type = request.getParameter("type");
		String card_no = request.getParameter("card_no");
		String se = request.getParameter("se");
		String  city=request.getParameter("city");
		String cardaddres=se+city;
	System.out.println("名字:"+name+"身份证:"+identity+"开户银行"+type+"卡号"+card_no+"地址:"+cardaddres);
        memberCard.setCard_no(card_no);
		memberCard.setCardaddress(cardaddres);
		memberCard.setType(type);
		memberCard.setMember(member);
		memberCard.setCreate_date(new Date());
        memberCard.getMember().setIdentity(identity);
        memberCard.getMember().setName(name);
		memberCardService.saveMemberCard(memberCard);
		return "redirect:/toFrontPersonage/touzi";
}

	@RequestMapping("/tocongzhi")
	public String congzhi(HttpSession session,Model model){
		//先取出用户的id
		Member member=(Member)session.getAttribute("member");
		if(member!=null){
			System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
			MemberAccount memberAccount=memberCardService.memberAccountById(member.getId());
			//根据登录人判断是否绑定银行卡
			List<MemberBankcards>memberBankcards=memberCardService.listMemberCard(member.getId());
		//	model.addAttribute("memberAccount", memberAccount);
		//	model.addAttribute("memberBankcards", memberBankcards);
			System.out.println("=========="+memberBankcards.isEmpty());
			if(memberBankcards.isEmpty()){
				return"redirect:/jilian/sheng";
			}
		}
    return "frontPersonage/index";
	}
	
	@RequestMapping("/topay")	//去付款
  //MemberTradeRecord充值记录表，MemberDepositRecord交易记录表
//记录表WIDout_trade_no订单编号WIDsubject订单名称WIDbody订单描述WIDtotal_amount输入的金额
//付款先获取页面上的四个属性，订单号，订单名称，付款金额，先存入session中，当支付成功后
//从session 得到这四个属性，然后进行表的操作
	public String topay(MemberTradeRecord memberTradeRecord,
	MemberDepositRecord memberDepositRecord,String WIDout_trade_no,String WIDsubject,
	String WIDbody,int WIDtotal_amount,String date,HttpSession session,SubjectPurchaseRecord subjectPurchaseRecord){
		//先从session里面获取用户
		Member member=(Member)session.getAttribute("member");

		//添加充值流水表
		memberDepositRecord.setAmount(WIDtotal_amount);
		
		System.out.println("sssssssssssss"+WIDtotal_amount);
		//添加购买流水表
		subjectPurchaseRecord.setSerial_number(WIDout_trade_no);
		// 添加创建日期
				memberDepositRecord.setCreate_date(new Date());
				// 添加修改日期
				memberDepositRecord.setUpdate_date(new Date());
   // 交易是否可用
		memberDepositRecord.setDelFlag(0);
		// 添加充值方
		memberDepositRecord.setPay_channel_name("支付宝充值");
		// 添加充值方订单号
		memberDepositRecord.setPay_channel_order_no(WIDout_trade_no);
		// 添加流水号
		memberDepositRecord.setSerial_number(WIDout_trade_no);
		// 添加充值状态
		memberDepositRecord.setStatus(0);
		// memberTradeRecord交易记录表
		memberTradeRecord.setAmount(WIDtotal_amount);
		memberTradeRecord.setCounterpart("金融中心");
	    memberTradeRecord.setFund_flow(1);
		memberTradeRecord.setTrade_name("支付宝充值" + WIDtotal_amount + "元");
		memberTradeRecord.setTrade_no(WIDout_trade_no);
		memberTradeRecord.setCreate_date(new Date());
		memberTradeRecord.setTrade_status(0);//交易状态
		memberTradeRecord.setUpdate_date(new Date());
		memberTradeRecord.setTrade_type("支付宝充值");
		memberTradeRecord.setMember(member);//充值记录表保存member对象
        memberDepositRecord.setMember(member);//交易记录表保存member对象
		//执行保存方法
        memberCardService.saveMemberDepositRecord(memberDepositRecord);
        memberCardService.saveMemberTradeRecord(memberTradeRecord);
        memberCardService.saveSubjectPurchaseRecord(subjectPurchaseRecord);
        //存入session中,支付成功后调用
		session.setAttribute("WIDtotal_amount", WIDtotal_amount);
		session.setAttribute("memberDepositRecord", memberDepositRecord);
		session.setAttribute("memberTradeRecord", memberTradeRecord);
		
		System.out.println("1111111111111111111111");
		return "frontPersonage/alipay.trade.page.pay";
	}
	
	@RequestMapping("/tonotice")
	public String tonotice(){
		System.out.println("2222222222222222222222");
		return "frontPersonage/notify_url";
	}
	
	@RequestMapping("/toreturn")
	//支付成功,Member_tally记账表里面的金额会发生改变
	//所有表的金额会发生改变
	public String toreturn(Member_tally member_tally,HttpSession session){
		Member member=(Member)session.getAttribute("member");
		MemberDepositRecord memberDepositRecord=(MemberDepositRecord)session.getAttribute("memberDepositRecord");
		MemberTradeRecord memberTradeRecord=(MemberTradeRecord)session.getAttribute("memberTradeRecord");
		//取出存入session的钱，然后加上可用余额，即充值成功
		int num=(int)session.getAttribute("WIDtotal_amount");
		Subject sub=(Subject)session.getAttribute("subject");
		//member_deposit_record(充值记录表)改变状态，变成支付完成
		memberDepositRecord.setStatus(1);
		memberDepositRecord.setCreate_date(new Date());
		//调用修改充值记录表的方法
		memberCardService.updateMemberDepositRecord(memberDepositRecord);
	  //改变交易记录表的状态
		memberTradeRecord.setTrade_status(1);
		memberTradeRecord.setExt_field_1("拓展一");
		memberTradeRecord.setExt_field_2("拓展2");
		memberTradeRecord.setExt_field_3("拓展3");
		//然后保存到数据库中
		memberCardService.saveMemberTradeRecord(memberTradeRecord);
		//然后查询这个用户的成员账户表
        MemberAccount memberAccount=this.memberCardService.memberAccountById(member.getId());
		//修改这个用户的可用金额
		memberAccount.setMember(member);
		memberAccount.setUseable_balance(memberAccount.getUseable_balance()+num);
		//保存成员账户表memberaccount
		this.memberCardService.saveMemberAccount(memberAccount);
		member_tally.setAmount(num);
		member_tally.setMember(member);
		member_tally.setCreate_date(new Date());
		member_tally.setType_id(1);
		member_tally.setType_name("支付宝充值");
		this.memberCardService.saveMember_tally(member_tally);
		session.setAttribute("memberDepositRecord", null);
		session.setAttribute("memberTradeRecord", null);
		session.setAttribute("WIDtotal_amount", null);
		if(sub==null){
			return"frontPersonage/touzi";
		}else{
			return "frontPersonage/return_url";
		}
		
		
		
	}
}
