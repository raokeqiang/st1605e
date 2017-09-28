package com.profit.bean;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name="news_type")  //新闻类别表
@Entity
public class NewsType {

	private int id;//主键
	private String name;//名称
//	private String link;//链接
//	private String note;//备注
	private int sort;//排序
//	private String pageType;//页面类型
	private int supType;//上级类别
	private String info;//简介
//	private String cPhoto;//封面图片
//	private String text;//内容
//	private String seoTiltle;//页面seo标题
//	private String seoKey;//seo关键字
//	private String seoDes;//seo描述
//	private int addId;//添加人ID
//	private int updId;//修改人ID
//	private Date updTime;//修改时间
	private Date addTime;//添加时间
	
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
//	public String getLink() {
//		return link;
//	}
//	public void setLink(String link) {
//		this.link = link;
//	}
//	public String getNote() {
//		return note;
//	}
//	public void setNote(String note) {
//		this.note = note;
//	}
	public int getSort() {
		return sort;
	}
	public void setSort(int sort) {
		this.sort = sort;
	}
//	public String getPageType() {
//		return pageType;
//	}
//	public void setPageType(String pageType) {
//		this.pageType = pageType;
//	}
	public int getSupType() {
		return supType;
	}
	public void setSupType(int supType) {
		this.supType = supType;
	}
//	public String getcPhoto() {
//		return cPhoto;
//	}
//	public void setcPhoto(String cPhoto) {
//		this.cPhoto = cPhoto;
//	}
//	public String getText() {
//		return text;
//	}
//	public void setText(String text) {
//		this.text = text;
//	}
//	public String getSeoTiltle() {
//		return seoTiltle;
//	}
//	public void setSeoTiltle(String seoTiltle) {
//		this.seoTiltle = seoTiltle;
//	}
//	public String getSeoKey() {
//		return seoKey;
//	}
//	public void setSeoKey(String seoKey) {
//		this.seoKey = seoKey;
//	}
//	public String getSeoDes() {
//		return seoDes;
//	}
//	public void setSeoDes(String seoDes) {
//		this.seoDes = seoDes;
//	}
//	public int getAddId() {
//		return addId;
//	}
//	public void setAddId(int addId) {
//		this.addId = addId;
//	}
//	public int getUpdId() {
//		return updId;
//	}
//	public void setUpdId(int updId) {
//		this.updId = updId;
//	}
//	public Date getUpdTime() {
//		return updTime;
//	}
//	public void setUpdTime(Date updTime) {
//		this.updTime = updTime;
//	}
	public Date getAddTime() {
		return addTime;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public void setAddTime(Date addTime) {
		this.addTime = addTime;
	}
}
