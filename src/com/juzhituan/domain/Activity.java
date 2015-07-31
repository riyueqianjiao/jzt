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
//@BatchSize(size=7)
@Table(name = "t_activity", catalog = "juzhituan")
public class Activity implements java.io.Serializable
{

	private Integer activityId;            //ID
	private Publication publication;       //属于哪个发布信息
	private Short   recruitNum;            //招聘人数
	private Short   recruitNumM;           //招聘人数:男
	private Short   applyNum;              //申请人数
	private Short   applyNumM;             //申请人数:男
	private Integer salary;                //若isLong=0,则按天；否则:按月
	private String  workAddress;           //工作地址
	private Date    workDate;              //工作日期
	private String  detail;                //工作详情
	private Byte    isGenderRequired;      //是否有性别要求，0:没有,1:有，2：只招女,3：只招男
	private Byte    state;                 //状态,0:报名状态，1：报名结束，2：申请取消，3：取消，4：完成
	private List<Participation> participations = new ArrayList<Participation>();

	
	public Activity()
	{
		this.applyNum=0;
		this.applyNumM=0;
		this.state=0;
	}
	public Activity(Integer activityId)
	{
		this.activityId=activityId;
		this.applyNum=0;
		this.applyNumM=0;
		this.state=0;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "activityId", unique = true, nullable = false)
	public Integer  getActivityId()
	{
		return this.activityId;
	}

	public void setActivityId(Integer activityId)
	{
		this.activityId = activityId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publicationId", nullable = false)
	public Publication getPublication()
	{
		return this.publication;
	}

	public void setPublication(Publication publication)
	{
		this.publication = publication;
	}

	@Column(name = "recruitNumM", nullable = false)
	public Short getRecruitNumM()
	{
		return this.recruitNumM;
	}

	public void setRecruitNumM(Short recruitNumM)
	{
		this.recruitNumM = recruitNumM;
	}
	
	@Column(name = "recruitNum", nullable = false)
	public Short getRecruitNum()
	{
		return this.recruitNum;
	}
	
	public void setRecruitNum(Short recruitNum)
	{
		this.recruitNum = recruitNum;
	}

	
	@Column(name = "applyNumM", nullable = false)
	public Short getApplyNumM()
	{
		return this.applyNumM;
	}

	public void setApplyNumM(Short applyNumM)
	{
		this.applyNumM = applyNumM;
	}
	
	@Column(name = "applyNum", nullable = false)
	public Short getApplyNum()
	{
		return this.applyNum;
	}
	
	public void setApplyNum(Short applyNum)
	{
		this.applyNum = applyNum;
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

	@Column(name = "workAddress", nullable = false, length = 200)
	public String getWorkAddress()
	{
		return this.workAddress;
	}

	public void setWorkAddress(String workAddress)
	{
		this.workAddress = workAddress;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "workDate", nullable = false, length = 10)
	public Date getWorkDate()
	{
		return this.workDate;
	}

	public void setWorkDate(Date workDate)
	{
		this.workDate = workDate;
	}
    
	@Column(name = "detail", nullable = false,length = 200)
	public String getDetail()
	{
		return this.detail;
	}

	public void setDetail(String detail)
	{
		this.detail=detail;
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
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "activity")
	public List<Participation> getParticipations()
	{
		return this.participations;
	}

	public void setParticipations(List<Participation> participations)
	{
		this.participations = participations;
	}
	
	/*
	 * 更新
	 * */
	public void update(Short recruitNum,Short recruitNumM,String workAddress,String detail,Integer salary)
	{
	   this.recruitNum=recruitNum;
	   this.recruitNumM=recruitNumM;
	   this.workAddress=workAddress;
	   this.detail=detail;
	   this.salary=salary;
	}

    

}
