package com.profit.service;
//绑卡的service

import java.util.List;

import com.profit.bean.Member;
import com.profit.bean.MemberAccount;
import com.profit.bean.MemberBankcards;
import com.profit.bean.MemberDepositRecord;
import com.profit.bean.MemberProfitRecord;
import com.profit.bean.MemberTradeRecord;
import com.profit.bean.Member_tally;
import com.profit.bean.Subject;
import com.profit.bean.SubjectPurchaseRecord;

public interface YsMemberCardService {
List<MemberBankcards>listMemberCard(int memberId);
//修改充值记录表和交易记录表
void updateMemberDepositRecord(MemberDepositRecord memberDepositRecord);
void updateMemberTradeRecord(MemberTradeRecord memberTradeRecord);

void updateMemberAccount(MemberAccount memberAccount);
void saveMemberCard(MemberBankcards membercard);
//根据id获取MemberBankcards对象银行卡绑定表表
MemberBankcards memberCardById(int memberId);
//根据i卡号获取MemberBankcards对象银行卡绑定表
boolean getMemberBankcardsKa(String card_no);
//保存充值记录表
void saveMemberDepositRecord(MemberDepositRecord memberDepositRecord);
List<Member>listMember();//查询成员表，为了显示余额
Member membergetById(int memberId);
//点击购买后subject表发生改变
Subject getSubjectById(int subjectId);
void upsubject(Subject subject);
//查询成员账户的对应的会员id
MemberAccount memberAccountById(int memberId);
void updatememberAccount(MemberAccount memberAccount);
void saveMemberAccount(MemberAccount memberAccount);
//操作交易记录表
void saveMemberTradeRecord(MemberTradeRecord memberTradeRecord);
//操作成员利润表
void saveMemberProfitRecord(MemberProfitRecord memberProfitRecord);
//操作记账表
void saveMember_tally(Member_tally member_tally);
//标的购买表
void saveSubjectPurchaseRecord(SubjectPurchaseRecord subjectPurchaseRecord);
List<SubjectPurchaseRecord>listSubjectPurchaseRecord(int subjectId);
//购买成功后的显示
List<SubjectPurchaseRecord>listSubpurchaseRecord();
//显示平台的账户余额
List<MemberDepositRecord> memberDepositRecords(int memberId);
}
