package com.profit.bean;



import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Table
@Entity
public class oversea_config {
	//海外配置表和海外配置预约表多对一，海外配置相当于部门，海外配置预约相当于员工表
     private int id; 
     private String title;//标题
     private String context;//内容
     private int sortColum;//排序值
     private String child_title;//子标题
     private String description;//描述
     private String user_type;//用户群体
     private String uptime;//修改时间
      private Date addTime;//创建时间
     private String oversea_icon;//图标
     private String start_time;//开始时间
     private String end_time;//结束时间
     private int status;//状态
     @Id
@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public int getSortColum() {
		return sortColum;
	}
	public void setSortColum(int sortColum) {
		this.sortColum = sortColum;
	}
	public String getChild_title() {
		return child_title;
	}
	public void setChild_title(String child_title) {
		this.child_title = child_title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getUser_type() {
		return user_type;
	}
	public void setUser_type(String user_type) {
		this.user_type = user_type;
	}
	public String getUptime() {
		return uptime;
	}
	public void setUptime(String uptime) {
		this.uptime = uptime;
	}
	
	



	public Date getAddTime() {
		return addTime;
	}

	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}

	public String getOversea_icon() {
		return oversea_icon;
	}
	public void setOversea_icon(String oversea_icon) {
		this.oversea_icon = oversea_icon;
	}
	public String getStart_time() {
		return start_time;
	}
	public void setStart_time(String start_time) {
		this.start_time = start_time;
	}
	public String getEnd_time() {
		return end_time;
	}
	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
     
}
