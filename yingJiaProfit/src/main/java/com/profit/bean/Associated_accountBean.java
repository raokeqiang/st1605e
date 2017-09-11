package com.profit.bean;

import java.util.Date;

public class Associated_accountBean {

	                 //associated_account     关联账号表（第三方登录信息表）
   private int id;        //         主键
   private int member_id;        //    COMMENT '会员id',
   private String type;        //  '账号类型（微信，QQ）',
   private String name;        //  '账号名称',
   private String identifying;        //  '账号标识',
   private int status;        //     身份,
   private Date create_date;        // '添加时间',
   private Date update_date;        //  '修改时间',
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
public String getType() {
	return type;
}
public void setType(String type) {
	this.type = type;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getIdentifying() {
	return identifying;
}
public void setIdentifying(String identifying) {
	this.identifying = identifying;
}
public int getStatus() {
	return status;
}
public void setStatus(int status) {
	this.status = status;
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

   
}
