package com.profit.dao;
//绑卡的方法

import java.util.List;

import org.hibernate.Session;

import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberBankcards;
import com.profit.bean.MemberProfitRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SubjectPurchaseRecord;

public interface YsMemberCardDao {
List<MemberBankcards> listMembercard();//绑卡
void saveMemberCard(MemberBankcards membercard);
Session getSession();
MemberBankcards getMemberById(int memberId);

List<Member>listMember();//查询成员表，为了显示余额
Member membergetById(int memberId);
//点击购买后subject表发生改变
Subject getSubjectById(int subjectId);
void upsubject(Subject subject);
//查询成员账户的对应的会员id
MemberAccount memberAccountById(int memberId);
void updatememberAccount(MemberAccount memberAccount);
//操作交易记录表
void saveMemberTradeRecord(MemberTradeRecord memberTradeRecord);
//操作成员利润表
void saveMemberProfitRecord(MemberProfitRecord memberProfitRecord);
//操作记账表
void saveMember_tally(Member_tally member_tally);
//标的购买表
void saveSubjectPurchaseRecord(SubjectPurchaseRecord subjectPurchaseRecord);
List<SubjectPurchaseRecord>listSubjectPurchaseRecord(int subjectId);
//购买之后次数加1，此时应该根据会员id和购买标的id同时进行操作

}