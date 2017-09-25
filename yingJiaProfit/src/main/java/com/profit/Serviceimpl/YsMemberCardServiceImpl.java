package com.profit.Serviceimpl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberBankcards;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberProfitRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SubjectPurchaseRecord;
import com.profit.dao.YsMemberCardDao;
import com.profit.service.YsMemberCardService;
@Service
@Transactional
public class YsMemberCardServiceImpl implements YsMemberCardService {
	@Autowired
	private YsMemberCardDao ysmeberCard;
	@Override
	public List<MemberBankcards> listMemberCard() {
		return ysmeberCard.listMembercard();
	}

	@Override
	public void saveMemberCard(MemberBankcards membercard) {
     this.ysmeberCard.saveMemberCard(membercard);
	}

	@Override
	public MemberBankcards memberCardById(int memberId) {
		return ysmeberCard.getMemberById(memberId);
	}

	@Override
	public List<Member> listMember() {
		return ysmeberCard.listMember();
	}

	@Override
	public Member membergetById(int memberId) {
		return this.ysmeberCard.membergetById(memberId);
	}

	@Override
	public MemberAccount memberAccountById(int memberId) {
		return this.ysmeberCard.memberAccountById(memberId);
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		return this.ysmeberCard.getSubjectById(subjectId);
	}

	@Override
	public void upsubject(Subject subject) {
    this.ysmeberCard.upsubject(subject);		
	}

	@Override
	public void updatememberAccount(MemberAccount memberAccount) {
     this.ysmeberCard.updatememberAccount(memberAccount);		
	}

	@Override
	public void saveMemberTradeRecord(MemberTradeRecord memberTradeRecord) {
    this.ysmeberCard.saveMemberTradeRecord(memberTradeRecord);		
	}

	@Override
	public void saveMemberProfitRecord(MemberProfitRecord memberProfitRecord) {
   this.ysmeberCard.saveMemberProfitRecord(memberProfitRecord);		
	}

	@Override
	public void saveMember_tally(Member_tally member_tally) {
  this.ysmeberCard.saveMember_tally(member_tally);		
	}

	@Override
	public void saveSubjectPurchaseRecord(SubjectPurchaseRecord subjectPurchaseRecord) {
      this.ysmeberCard.saveSubjectPurchaseRecord(subjectPurchaseRecord);		
	}

	@Override
	public List<SubjectPurchaseRecord> listSubjectPurchaseRecord(int subjectId) {
		return this.ysmeberCard.listSubjectPurchaseRecord(subjectId);
	}

	@Override
	public List<SubjectPurchaseRecord> listSubpurchaseRecord() {
		return this.ysmeberCard.listSubpurchaseRecord();
	}

	@Override
	public List<MemberDepositRecord> memberDepositRecords(int memberId) {
		return this.ysmeberCard.memberDepositRecords(memberId);
	}

}
