package com.profit.bean;

import java.util.Date;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Subject") // 主题表
public class Subject {
	private int id;//主键
    private String serial_number;//流水号
    private String serial_no;//合同号
    private String name;//标的名称
    private int type;//标的类型
    private int status;//标的状态
    private int floor_amount;//起投金额
    private int amount;//标的金额 
    private int first_id;//始标id
    private int parent_id;//父标id
    private int period;//标的周期
    private String purpose;//借款目的
    private Date raise_start;//募集开始
    private Date raise_end;//募集结束
    private int refund_way;//还款方式
    private int safeGuard_way;//保障方式
//    private Date start_date;//标的开始日期
//    private Date end_date;//标的结束日期
    private double year_rate;//年化率
    private String comment;//产品速览
    private int folder_id;//文件夹id
    private int delflag;//是否删除
    private Date update_date;//更新日期
    private Date create_date;//创建日期
    private String borrowername;//借款人姓名
    private int borrowerid;//借款人id
    private int bought;//已购人数
    private String projectDetails;//项目详情
    private String safetyControl;//安全保障
    private int exper_status;//体验金是否可以购买（0：否，1：是）
  //private SubjectFolder subjectFolder;
    private Set<MemberProfitRecord>memberProfitRecords=new HashSet<MemberProfitRecord>();
private Set<SubjectBbinPurchassRecord> SubjectBbinPurchassRecord = new HashSet<SubjectBbinPurchassRecord>();
	//private Set<SubjectFieldRecord> subjectFieldRecords = new HashSet<>();
	//private Set<SubjectOrderRecord> subjectOrderRecords = new HashSet<>();
	private Set<SubjectPurchaseRecord> subjectPurchaseRecord = new HashSet<SubjectPurchaseRecord>();
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getSerial_number() {
		return serial_number;
	}

	public void setSerial_number(String serial_number) {
		this.serial_number = serial_number;
	}

	public String getSerial_no() {
		return serial_no;
	}

	public void setSerial_no(String serial_no) {
		this.serial_no = serial_no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public int getFloor_amount() {
		return floor_amount;
	}

	public void setFloor_amount(int floor_amount) {
		this.floor_amount = floor_amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getFirst_id() {
		return first_id;
	}

	public void setFirst_id(int first_id) {
		this.first_id = first_id;
	}

	public int getParent_id() {
		return parent_id;
	}

	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public int getPeriod() {
		return period;
	}

	public void setPeriod(int period) {
		this.period = period;
	}

	public String getPurpose() {
		return purpose;
	}

	public void setPurpose(String purpose) {
		this.purpose = purpose;
	}

	public Date getRaise_start() {
		return raise_start;
	}

	public void setRaise_start(Date raise_start) {
		this.raise_start = raise_start;
	}

	public Date getRaise_end() {
		return raise_end;
	}

	public void setRaise_end(Date raise_end) {
		this.raise_end = raise_end;
	}

	public int getRefund_way() {
		return refund_way;
	}

	public void setRefund_way(int refund_way) {
		this.refund_way = refund_way;
	}

	public int getSafeGuard_way() {
		return safeGuard_way;
	}

	public void setSafeGuard_way(int safeGuard_way) {
		this.safeGuard_way = safeGuard_way;
	}

//	public Date getStart_date() {
//		return start_date;
//	}

//	public void setStart_date(Date start_date) {
//		this.start_date = start_date;
//	}
//
//	public Date getEnd_date() {
//		return end_date;
//	}
//
//	public void setEnd_date(Date end_date) {
//		this.end_date = end_date;
//	}

	public String getComment() {
		return comment;
	}

	public double getYear_rate() {
		return year_rate;
	}

	public void setYear_rate(double year_rate) {
		this.year_rate = year_rate;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getFolder_id() {
		return folder_id;
	}

	public void setFolder_id(int folder_id) {
		this.folder_id = folder_id;
	}

	public int getDelflag() {
		return delflag;
	}

	public void setDelflag(int delflag) {
		this.delflag = delflag;
	}

	public Date getUpdate_date() {
		return update_date;
	}

	public void setUpdate_date(Date update_date) {
		this.update_date = update_date;
	}

	public Date getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Date create_date) {
		this.create_date = create_date;
	}

	public String getBorrowername() {
		return borrowername;
	}

	public void setBorrowername(String borrowername) {
		this.borrowername = borrowername;
	}

	public int getBorrowerid() {
		return borrowerid;
	}

	public void setBorrowerid(int borrowerid) {
		this.borrowerid = borrowerid;
	}

	public int getBought() {
		return bought;
	}

	public void setBought(int bought) {
		this.bought = bought;
	}

	public String getProjectDetails() {
		return projectDetails;
	}

	public void setProjectDetails(String projectDetails) {
		this.projectDetails = projectDetails;
	}

	public String getSafetyControl() {
		return safetyControl;
	}

	public void setSafetyControl(String safetyControl) {
		this.safetyControl = safetyControl;
	}

	public int getExper_status() {
		return exper_status;
	}

	public void setExper_status(int exper_status) {
		this.exper_status = exper_status;
	}
	//bi-directional OneToMany association to Subject
	@OneToMany(mappedBy="subject")
	public Set<SubjectPurchaseRecord> getSubjectPurchaseRecord() {
		return subjectPurchaseRecord;
	}

	public void setSubjectPurchaseRecord(Set<SubjectPurchaseRecord> subjectPurchaseRecord) {
		this.subjectPurchaseRecord = subjectPurchaseRecord;
	}

	
	//bi-directional many-to-one association to SubjectFolder
	/*	@ManyToOne
		@JoinColumn(name="folder_id")
		public SubjectFolder getSubjectFolder() {
			return this.subjectFolder;
		}
	 public void setSubjectFolder(SubjectFolder subjectFolder) {
			this.subjectFolder = subjectFolder;
		}
	*/

//bi-directional many-to-one association to SubjectBbinPurchaseRecord
		@OneToMany(cascade = CascadeType.ALL,mappedBy="subject")
		public Set<SubjectBbinPurchassRecord> getSubjectBbinPurchassRecord() {
			return SubjectBbinPurchassRecord;
		}

		public void setSubjectBbinPurchassRecord(Set<SubjectBbinPurchassRecord> subjectBbinPurchassRecord) {
			SubjectBbinPurchassRecord = subjectBbinPurchassRecord;
		}
		@OneToMany
       public Set<MemberProfitRecord> getMemberProfitRecords() {
			return memberProfitRecords;
		}

		public void setMemberProfitRecords(Set<MemberProfitRecord> memberProfitRecords) {
			this.memberProfitRecords = memberProfitRecords;
		}
		
		
		
		

	/*	public SubjectBbinPurchaseRecord addSubjectBbinPurchaseRecord(SubjectBbinPurchaseRecord subjectBbinPurchaseRecord) {
			getSubjectBbinPurchaseRecords().add(subjectBbinPurchaseRecord);
			subjectBbinPurchaseRecord.setSubject(this);

			return subjectBbinPurchaseRecord;
		}

		public SubjectBbinPurchaseRecord removeSubjectBbinPurchaseRecord(SubjectBbinPurchaseRecord subjectBbinPurchaseRecord) {
			getSubjectBbinPurchaseRecords().remove(subjectBbinPurchaseRecord);
			subjectBbinPurchaseRecord.setSubject(null);

			return subjectBbinPurchaseRecord;
		}*/


	/*		//bi-directional many-to-one association to SubjectFieldRecord
		@OneToMany(mappedBy="subject")
		public Set<SubjectFieldRecord> getSubjectFieldRecords() {
			return this.subjectFieldRecords;
		}

		public void setSubjectFieldRecords(Set<SubjectFieldRecord> subjectFieldRecords) {
			this.subjectFieldRecords = subjectFieldRecords;
		}
	*/
	/*	public SubjectFieldRecord addSubjectFieldRecord(SubjectFieldRecord subjectFieldRecord) {
			getSubjectFieldRecords().add(subjectFieldRecord);
			subjectFieldRecord.setSubject(this);

			return subjectFieldRecord;
		}

		public SubjectFieldRecord removeSubjectFieldRecord(SubjectFieldRecord subjectFieldRecord) {
			getSubjectFieldRecords().remove(subjectFieldRecord);
			subjectFieldRecord.setSubject(null);

			return subjectFieldRecord;
		}*/


	/*	//bi-directional many-to-one association to SubjectOrderRecord
		@OneToMany(mappedBy="subject")
		public Set<SubjectOrderRecord> getSubjectOrderRecords() {
			return this.subjectOrderRecords;
		}

		public void setSubjectOrderRecords(Set<SubjectOrderRecord> subjectOrderRecords) {
			this.subjectOrderRecords = subjectOrderRecords;
		}*/

	/*	public SubjectOrderRecord addSubjectOrderRecord(SubjectOrderRecord subjectOrderRecord) {
			getSubjectOrderRecords().add(subjectOrderRecord);
			subjectOrderRecord.setSubject(this);

			return subjectOrderRecord;
		}

		public SubjectOrderRecord removeSubjectOrderRecord(SubjectOrderRecord subjectOrderRecord) {
			getSubjectOrderRecords().remove(subjectOrderRecord);
			subjectOrderRecord.setSubject(null);

			return subjectOrderRecord;
		}*/
	}



