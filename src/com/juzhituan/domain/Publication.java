package com.juzhituan.domain;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_publication", catalog = "juzhituan")
public class Publication implements java.io.Serializable
{

	private Integer  publicationId;        //ID
	private Employer employer;             //属于哪个商家
	private String   publicationNum;       //发布编号
	private String   companyName;          //公司名称
	private Integer  recruitmentTime;      //第几次发布
	private String   title;                //标题
	private String   detail;               //详情
	private Integer  salary;               //工资
	private String   requirement;          //其他要求
	private String   contactName;          //联系人  
	private String   cellphone;            //手机
	private Date     startDate;            //开始工作日期
	private String   workAddress;          //工作地址
	private Byte     workDuration;         //工作天数
	private String   workTimeInfo;         //工作时间
	private Date     publicationTime;      //发布时间
	private Byte     paymentWay;           //支付方式，0:由商家直接支付给求职者；1：由聚职团代为支付
	private Byte     settlementWay;        //结算方式, 0:按天结算，1：若isLong=1,按月结算
	private Byte     workType;             //工作类型，0：其他,1:传单派发，2：酒店服务员，3：促销,4:礼仪，5：营业员，6：工厂兼职
	private Byte     isLong;               //是否为长期
	private Byte     isGenderRequired;     //是否有性别要求，0:没有,1:有，2：只招女,3：只招男
	private Byte     state;                //状态,0:报名状态，1：报名结束，2：申请取消，3：取消，4：完成
	
	
	private List<Comment> comments = new ArrayList<Comment>();
	private List<Activity> activities = new ArrayList<Activity>();

	public Publication()
	{
		this.paymentWay=0;
		this.settlementWay=0;
		this.workType=0;
		this.isLong=0;
		this.isGenderRequired=0;
		this.state=0;
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "publicationId", unique = true, nullable = false)
	public Integer getPublicationId()
	{
		return this.publicationId;
	}

	public void setPublicationId(Integer publicationId)
	{
		this.publicationId = publicationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employerId")
	public Employer getEmployer()
	{
		return this.employer;
	}

	public void setEmployer(Employer employer)
	{
		this.employer = employer;
	}
    
	@Column(name = "publicationNum", nullable = false, length = 17)
	public String getPublicationNum()
	{
		return publicationNum;
	}

	public void setPublicationNum(String publicationNum)
	{
		this.publicationNum = publicationNum;
	}
	
	
	@Column(name = "companyName", nullable = false, length = 100)
	public String getCompanyName()
	{
		return this.companyName;
	}

	public void setCompanyName(String companyName)
	{
		this.companyName = companyName;
	}
	
	@Column(name = "recruitmentTime",nullable=false)
	public Integer getRecruitmentTime()
	{
		return this.recruitmentTime;
	}
	
	public void setRecruitmentTime(Integer recruitmentTime)
	{
		this.recruitmentTime = recruitmentTime;
	}
	
	@Column(name = "title", nullable = false, length = 24)
	public String getTitle()
	{
		return this.title;
	}

	public void setTitle(String title)
	{
		this.title=title;
	}
	
	@Column(name = "salary", nullable = false)
	public Integer getSalary()
	{
		return this.salary;
	}

	public void setSalary(Integer salary)
	{
		this.salary = salary;
	}
	
	@Column(name = "detail",length = 200)
	public String getDetail()
	{
		return this.detail;
	}
	
	public void setDetail(String detail)
	{
		this.detail=detail;
	}
	
	@Column(name = "requirement",length = 200)
	public String getRequirement()
	{
		return this.requirement;
	}
	
	public void setRequirement(String requirement)
	{
		this.requirement=requirement;
	}
	
    
	@Column(name = "contactName", nullable = false, length = 20)
	public String getContactName()
	{
		return this.contactName;
	}

	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	@Column(name = "cellphone", nullable = false, length = 11)
	public String getCellphone()
	{
		return this.cellphone;
	}

	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "startDate", nullable = false, length = 10)
	public Date getStartDate()
	{
		return this.startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}
    
	@Column(name = "workAddress", nullable = false, length = 200)
	public String getWorkAddress()
	{
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress)
	{
		this.workAddress = workAddress;
	}
	
	@Column(name = "workDuration", nullable = false)
	public Byte getWorkDuration()
	{
		return this.workDuration;
	}

	public void setWorkDuration(Byte workDuration)
	{
		this.workDuration = workDuration;
	}
	
	@Column(name = "workTimeInfo", nullable = false, length = 100)
	public String getWorkTimeInfo()
	{
		return workTimeInfo;
	}

	public void setWorkTimeInfo(String workTimeInfo)
	{
		this.workTimeInfo = workTimeInfo;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "publicationTime", nullable = false, length = 19)
	public Date getPublicationTime()
	{
		return this.publicationTime;
	}

	public void setPublicationTime(Date publicationTime)
	{
		this.publicationTime = publicationTime;
	}

	@Column(name = "paymentWay", nullable = false)
	public Byte getPaymentWay()
	{
		return this.paymentWay;
	}

	public void setPaymentWay(Byte paymentWay)
	{
		this.paymentWay = paymentWay;
	}
	
	@Column(name = "settlementWay", nullable = false)
	public Byte getSettlementWay()
	{
		return this.settlementWay;
	}
	
	public void setSettlementWay(Byte settlementWay)
	{
		this.settlementWay=settlementWay;
	}
	

	@Column(name = "workType", nullable = false)
	public Byte getWorkType()
	{
		return this.workType;
	}
	
	public void setWorkType(Byte workType)
	{
		this.workType=workType;
	}
	
	@Column(name = "isLong", nullable = false)
	public Byte getIsLong()
	{
		return this.isLong;
	}
	
	public void setIsLong(Byte isLong)
	{
		this.isLong=isLong;
	}
	
	@Column(name = "isGenderRequired", nullable = false)
	public Byte getIsGenderRequired()
	{
		return this.isGenderRequired;
	}
	
	public void setIsGenderRequired(Byte isGenderRequired)
	{
		this.isGenderRequired=isGenderRequired;
	}
	
	
	@Column(name = "state", nullable = false)
	public Byte getState()
	{
		return this.state;
	}

	public void setState(Byte state)
	{
		this.state = state;
	}
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publication")
	public List<Comment> getComments()
	{
		return this.comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments =comments;
	}
	

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "publication")
	public List<Activity> getActivities()
	{
		return this.activities;
	}

	public void setActivities(List<Activity> activities)
	{
		this.activities =activities;
	}

	

	
}
