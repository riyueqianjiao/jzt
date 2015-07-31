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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table(name = "t_employee", catalog = "juzhituan")
public class Employee implements java.io.Serializable
{

	private Integer employeeId;
	private String employeeName;
	private String cellphone;
	private String password;
	private String alipayNum;
	private String gender;
	private String icon;
	private Date   registerTime;
	private Byte   isLocked;
	private Date   lastLockedTime;
	private List<EmployeePaid> employeePaids = new ArrayList<EmployeePaid>();
	private List<Comment> comments = new ArrayList<Comment>();
	private List<Participation> participations = new ArrayList<Participation>();

	public Employee()
	{
		this.isLocked=0;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeeId", unique = true, nullable = false)
	public Integer getEmployeeId()
	{
		return this.employeeId;
	}

	public void setEmployeeId(Integer employeeId)
	{
		this.employeeId = employeeId;
	}

	@Column(name = "employeeName", nullable = false, length = 50)
	public String getEmployeeName()
	{
		return this.employeeName;
	}

	public void setEmployeeName(String employeeName)
	{
		this.employeeName = employeeName;
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

	@Column(name = "password", nullable = false, length = 32)
	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}


	@Column(name = "alipayNum", length = 50)
	public String getAlipayNum()
	{
		return this.alipayNum;
	}

	public void setAlipayNum(String alipayNum)
	{
		this.alipayNum = alipayNum;
	}

	@Column(name = "gender", nullable = false, length = 1)
	public String getGender()
	{
		return this.gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	@Column(name = "icon", length = 50)
	public String getIcon()
	{
		return this.icon;
	}

	public void setIcon(String icon)
	{
		this.icon = icon;
	}
    
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "registerTime", nullable = false, length = 19)
	public Date getRegisterTime()
	{
		return this.registerTime;
	}

	public void setRegisterTime(Date registerTime)
	{
		this.registerTime = registerTime;
	}
    
	@Column(name = "isLocked", nullable = false)
	public Byte getIsLocked()
	{
		return this.isLocked;
	}

	public void setIsLocked(Byte isLocked)
	{
		this.isLocked =isLocked;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "lastLockedTime", nullable = true, length = 19)
	public Date getLastLockedTime()
	{
		return this.lastLockedTime;
	}

	public void setLastLockedTime(Date lastLockedTime)
	{
		this.lastLockedTime = lastLockedTime;
	}
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public List<EmployeePaid> getEmployeePaids()
	{
		return this.employeePaids;
	}

	public void setEmployeePaids(List<EmployeePaid> employeePaids)
	{
		this.employeePaids =employeePaids;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public List<Comment> getComments()
	{
		return this.comments;
	}

	public void setComments(List<Comment> comments)
	{
		this.comments = comments;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employee")
	public List<Participation> getParticipations()
	{
		return this.participations;
	}

	public void setParticipations(List<Participation> participations)
	{
		this.participations =participations;
	}

}
