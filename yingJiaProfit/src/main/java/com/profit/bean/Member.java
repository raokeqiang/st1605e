package com.profit.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Table(name="Member")//用户基本表
@Entity
public class Member {

	private int id;//用户id
	private String member_name;//真实姓名
	private String name;//用户名
	private String password;//密码
	private String salt;//密码盐
	private String mobile_Phone;//手机号
	private int status;//账号状态（正常，锁定，删除
	private int del_flag;//删除标志
	private String identity;//身份
	private Date create_date;//创建时间
	private Date update_date;//修改时间
	private String weiBoAccount;//微博账号关联
	private String weixinAccount;//微信账号关联
	private int headid;//头像图片id
	private String invitationCode;//邀请码
	private String withdraw_password;//提款密码
	private String qqAccount;//QQ账号关联
	private String invitedCode;//被邀请码
	private String qqNumber;//QQ号码
	private Set<MemberAccount>memberAccount=new HashSet<MemberAccount>();
	private Set<SubjectBbinPurchassRecord> SubjectBbinPurchassRecord = new HashSet<SubjectBbinPurchassRecord>();
	private Set<SubjectPurchaseRecord>subjectPurchaseRecords=new HashSet<SubjectPurchaseRecord>();
	private Set<MemberProfitRecord> memberProfitRecords = new HashSet<MemberProfitRecord>();
	private Set<MemberTradeRecord> memberTradeRecords = new HashSet<MemberTradeRecord>();
	private Set<Member_tally> member_tally = new HashSet<Member_tally>();
	private Set<MemberDepositRecord> memberDepositRecords = new HashSet<>();
	
	@OneToMany(mappedBy="member")
    public Set<MemberDepositRecord> getMemberDepositRecords() {
		return memberDepositRecords;
	}
	public void setMemberDepositRecords(Set<MemberDepositRecord> memberDepositRecords) {
		this.memberDepositRecords = memberDepositRecords;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getSalt() {
		return salt;
	}
	public void setSalt(String salt) {
		this.salt = salt;
	}
	public String getMobile_Phone() {
		return mobile_Phone;
	}
	public void setMobile_Phone(String mobile_Phone) {
		this.mobile_Phone = mobile_Phone;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDel_flag() {
		return del_flag;
	}
	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}
	public String getIdentity() {
		return identity;
	}
	public void setIdentity(String identity) {
		this.identity = identity;
	}
	public Date getCreate_date() {
		return create_date;
	}
	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}
	public Date getUpdate_date() {
		return update_date;
	}
	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}
	public String getWeiBoAccount() {
		return weiBoAccount;
	}
	public void setWeiBoAccount(String weiBoAccount) {
		this.weiBoAccount = weiBoAccount;
	}
	public String getWeixinAccount() {
		return weixinAccount;
	}
	public void setWeixinAccount(String weixinAccount) {
		this.weixinAccount = weixinAccount;
	}
	public int getHeadid() {
		return headid;
	}
	public void setHeadid(int headid) {
		this.headid = headid;
	}
	public String getInvitationCode() {
		return invitationCode;
	}
	public void setInvitationCode(String invitationCode) {
		this.invitationCode = invitationCode;
	}
	public String getWithdraw_password() {
		return withdraw_password;
	}
	public void setWithdraw_password(String withdraw_password) {
		this.withdraw_password = withdraw_password;
	}
	public String getQqAccount() {
		return qqAccount;
	}
	public void setQqAccount(String qqAccount) {
		this.qqAccount = qqAccount;
	}
	public String getInvitedCode() {
		return invitedCode;
	}
	public void setInvitedCode(String invitedCode) {
		this.invitedCode = invitedCode;
	}
	public String getQqNumber() {
		return qqNumber;
	}
	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}
	//bi-directional many-to-one association to SubjectOrderRecord
		@OneToMany(mappedBy="member")
	public Set<SubjectBbinPurchassRecord> getSubjectBbinPurchassRecord() {
		return SubjectBbinPurchassRecord;
	}
	public void setSubjectBbinPurchassRecord(Set<SubjectBbinPurchassRecord> subjectBbinPurchassRecord) {
		SubjectBbinPurchassRecord = subjectBbinPurchassRecord;
	}
	//bi-directional many-to-one association to MemberAccount
		@OneToMany(mappedBy="member")
	public Set<MemberAccount> getMemberAccount() {
		return memberAccount;
	}
	public void setMemberAccount(Set<MemberAccount> memberAccount) {
		this.memberAccount = memberAccount;
	}
	//bi-directional many-to-one association to MemberProfitRecord
		@OneToMany(mappedBy="member")
	public Set<MemberProfitRecord> getMemberProfitRecords() {
		return memberProfitRecords;
	}
	public void setMemberProfitRecords(Set<MemberProfitRecord> memberProfitRecords) {
		this.memberProfitRecords = memberProfitRecords;
	}
	//bi-directional many-to-one association to MemberTradeRecord
		@OneToMany(mappedBy="member")
	public Set<MemberTradeRecord> getMemberTradeRecords() {
		return memberTradeRecords;
	}
	public void setMemberTradeRecords(Set<MemberTradeRecord> memberTradeRecords) {
		this.memberTradeRecords = memberTradeRecords;
	}
	//bi-directional many-to-one association to MemberTally
		@OneToMany(mappedBy="member")
	public Set<Member_tally> getMember_tally() {
		return member_tally;
	}
	public void setMember_tally(Set<Member_tally> member_tally) {
		this.member_tally = member_tally;
	}
	@OneToMany(mappedBy="member")
	public Set<SubjectPurchaseRecord> getSubjectPurchaseRecords() {
		return subjectPurchaseRecords;
	}
	public void setSubjectPurchaseRecords(Set<SubjectPurchaseRecord> subjectPurchaseRecords) {
		this.subjectPurchaseRecords = subjectPurchaseRecords;
	}
	
}
