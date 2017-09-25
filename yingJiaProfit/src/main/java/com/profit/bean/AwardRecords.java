package com.profit.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Table(name="Award_records")//'奖励记录表'
@Entity
public class AwardRecords {

	private int id;//主键
	private Member invitingid;//邀请人id
	private Member byinvitingid;//被邀请人id
	private int type;//奖励类型（0：注册奖励，1：投资奖励）
	private int amount;//奖励金额
	private int isAward;//0:未奖励  1：已奖励
	private Date addTime;//添加时间
	
	@ManyToOne
	@JoinColumn(name="invitingid")
	public Member getInvitingid() {
		return invitingid;
	}
	public void setInvitingid(Member invitingid) {
		this.invitingid = invitingid;
	}
	@ManyToOne
	@JoinColumn(name="byinvitingid")
	public Member getByinvitingid() {
		return byinvitingid;
	}
	public void setByinvitingid(Member byinvitingid) {
		this.byinvitingid = byinvitingid;
	}
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getIsAward() {
		return isAward;
	}
	public void setIsAward(int isAward) {
		this.isAward = isAward;
	}
	public Date getAddTime() {
		return addTime;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
	
}
