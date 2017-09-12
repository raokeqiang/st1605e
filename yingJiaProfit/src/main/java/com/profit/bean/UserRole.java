package com.profit.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "User_role") // 角色表
public class UserRole {

	private int id;// 主键
	private String cname;// 中文名
	private String ename;// 英文名
	private int available;// 是否可用
	private String remark;// 备注
	private Date create_date;// 创建时间
	private Date update_date;// 修改时间
	private String category;// 类别
	private int source_type;
	private int source_id;
	private int del_flag;
	private Set<Resources> resour=new HashSet<Resources>();
	
	
 	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="role_Res",joinColumns=@JoinColumn(name="rid"),inverseJoinColumns=@JoinColumn(name="pid"))
	public Set<Resources> getResour() {
		return resour;
	}

	public void setResour(Set<Resources> resour) {
		this.resour = resour;
	}

	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCname() {
		return cname;
	}

	public void setCname(String cname) {
		this.cname = cname;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public int getAvailable() {
		return available;
	}

	public void setAvailable(int available) {
		this.available = available;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getSource_type() {
		return source_type;
	}

	public void setSource_type(int source_type) {
		this.source_type = source_type;
	}

	public int getSource_id() {
		return source_id;
	}

	public void setSource_id(int source_id) {
		this.source_id = source_id;
	}

	public int getDel_flag() {
		return del_flag;
	}

	public void setDel_flag(int del_flag) {
		this.del_flag = del_flag;
	}

}
