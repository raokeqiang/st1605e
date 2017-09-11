package com.profit.bean;


import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Table
@Entity
public class oversea_config_subscribe {
	//(海外配置订阅表)
	private int id;
	private int member_id;//会员id
	private  String name;//姓名
	private String phone;//电话
	private String addr;//地址
	private int status;//状态
	private Date create_time;//创建时间
	private Date update_time;//修改时间
	private oversea_config oversea;
	  @Id
	  @GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMember_id() {
		return member_id;
	}
	public void setMember_id(int member_id) {
		this.member_id = member_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getCreate_time() {
		return create_time;
	}
	public void setCreate_time(Date create_time) {
		this.create_time = create_time;
	}
	public Date getUpdate_time() {
		return update_time;
	}
	public void setUpdate_time(Date update_time) {
		this.update_time = update_time;
	}
	@ManyToOne
	@JoinColumn(name="oversea_id")
	public oversea_config getOversea() {
		return oversea;
	}
	public void setOversea(oversea_config oversea) {
		this.oversea = oversea;
	}
	  
}
