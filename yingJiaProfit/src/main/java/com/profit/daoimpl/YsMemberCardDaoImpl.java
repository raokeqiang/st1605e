package com.profit.daoimpl;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
@Component
public class YsMemberCardDaoImpl implements YsMemberCardDao{
	@Autowired
	public SessionFactory sessionFactory;
	@Override
	public List<MemberBankcards> listMembercard(int memberId) {
		Session session=getSession();
		String hql= "from MemberBankcards m where m.member.id="+memberId;
		List<MemberBankcards> list=session.createQuery(hql).list();
		return list;
	}

	@Override
	public void saveMemberCard(MemberBankcards membercard) {
      Session session=getSession();
      session.save(membercard);
	}

	@Override
	public Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public MemberBankcards getMemberById(int memberId) {
		//绑卡的表,根据id
		Session session=getSession();
		String hql="from MemberBankcards m where m.member.id="+memberId;
		List<MemberBankcards> list=session.createQuery(hql).list();
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}
	@Override
	public boolean getMemberBankcardsKa(String card_no) {
		//根据i卡号获取MemberBankcards对象银行卡绑定表
		Session session=getSession();
		String hql="from MemberBankcards where card_no="+card_no;
		List<MemberBankcards>list=session.createQuery(hql).list();
		if (list.size() > 0) {
			return false;
		}
		return true;
	}




	@Override
	public List<Member> listMember() {
		Session session=getSession();
		List<Member>listmember=session.createQuery("from member").list();
		return listmember;
	}

	@Override
	public Member membergetById(int memberId) {
		Session session=getSession();
		Member  member =(Member)session.get(Member.class, memberId);
		return member;		
	}

	@Override
	public MemberAccount memberAccountById(int memberId) {
		Session session=getSession();
		String hql="from MemberAccount ma where ma.member.id="+memberId;
		List<MemberAccount> list=session.createQuery(hql).list() ;
		if(list.size()>0){
			return list.get(0);
		}
		return null;
	}

	@Override
	public Subject getSubjectById(int subjectId) {
		Session session=getSession();
		Subject subject=(Subject)session.get(Subject.class, subjectId);
		return subject;
	}

	@Override
	public void upsubject(Subject subject) {
  Session session=getSession();
  session.update(subject);
	}

	@Override
	public void updatememberAccount(MemberAccount memberAccount) {
 Session session=getSession();
 session.update(memberAccount);
	}

	@Override
	public void saveMemberTradeRecord(MemberTradeRecord memberTradeRecord) {
Session session=getSession();
session.save(memberTradeRecord);
	}

	@Override
	public void saveMemberProfitRecord(MemberProfitRecord memberProfitRecord) {
  Session session=getSession();
  session.save(memberProfitRecord);
	}

	@Override
	public void saveMember_tally(Member_tally member_tally) {
Session session=getSession();
session.save(member_tally);
	}

	@Override
	public void saveSubjectPurchaseRecord(SubjectPurchaseRecord subjectPurchaseRecord) {
    Session session=getSession();
  session.save(subjectPurchaseRecord);
	}

	@Override
	public List<SubjectPurchaseRecord> listSubjectPurchaseRecord(int subjectId) {
		Session session=getSession();
		String hql="from SubjectPurchaseRecord ss where ss.subject.id="+subjectId;
		List<SubjectPurchaseRecord> list=session.createQuery(hql).list();
		if(list.size()>0){
		 SubjectPurchaseRecord aa=list.get(0);
		}
		return null;
	}

	@Override
	public List<SubjectPurchaseRecord> listSubpurchaseRecord() {
		Session session=getSession();
		List<SubjectPurchaseRecord>list=session.createQuery("from SubjectPurchaseRecord").list();
		return list;
	}
	// 根据id查询充值记录表
	@Override
	public List<MemberDepositRecord> memberDepositRecords(int memberId) { 
		Session session=getSession();
		String hql="from MemberDepositRecord m where m.member.id"+memberId;
		List<MemberDepositRecord> list=session.createQuery(hql).list();
		if (list.size() > 0) {
			return list;
		}
		return null;
	}

	@Override
	public void saveMemberDepositRecord(MemberDepositRecord memberDepositRecord) {
		Session session=getSession();
		session.save(memberDepositRecord);
	}

	@Override
	public void updateMemberDepositRecord(MemberDepositRecord memberDepositRecord) {
		  Session session=getSession();
		  session.update(memberDepositRecord);
	}

	@Override
	public void updateMemberTradeRecord(MemberTradeRecord memberTradeRecord) {
     Session session=getSession();
     session.update(memberTradeRecord);
	}

	@Override
	public void updateMemberAccount(MemberAccount memberAccount) {
      Session session=getSession();
      session.update(memberAccount);
	}

	@Override
	public void saveMemberAccount(MemberAccount memberAccount) {
   Session session=getSession();
   session.save(memberAccount);
	}



	
}




