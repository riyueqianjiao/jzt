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
@Table(name = "t_employer", catalog = "juzhituan")
public class Employer implements java.io.Serializable
{

	private Integer  employerId;
	private String   companyName;
	private String   city;
	private String   companyPhone;
	private String   cellphone;
	private String   contactName;
	private String   companyAddress;
	private String   companyInfo;
	private Byte     remarkPoint;
	private Integer  recruitmentTime;
	private Date     registerTime;
	private Double   balance;
	private String   licenseNum;
	private String   employerName;
	private String   password;
	private String   email;
	private String   icon;
	private List<Publication> publications = new ArrayList<Publication>();
	private List<EmployerPayment> employerPayments = new ArrayList<EmployerPayment>();

	public Employer()
	{
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employerId", unique = true, nullable = false)
	public Integer getEmployerId()
	{
		return this.employerId;
	}

	public void setEmployerId(Integer employerId)
	{
		this.employerId = employerId;
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

	@Column(name = "city", nullable = false, length = 50)
	public String getCity()
	{
		return this.city;
	}

	public void setCity(String city)
	{
		this.city = city;
	}

	@Column(name = "companyPhone", nullable = false, length = 13)
	public String getCompanyPhone()
	{
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone)
	{
		this.companyPhone = companyPhone;
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

	@Column(name = "contactName", nullable = false, length = 20)
	public String getContactName()
	{
		return this.contactName;
	}

	public void setContactName(String contactName)
	{
		this.contactName = contactName;
	}

	@Column(name = "companyAddress", nullable = false, length = 100)
	public String getCompanyAddress()
	{
		return this.companyAddress;
	}

	public void setCompanyAddress(String companyAddress)
	{
		this.companyAddress = companyAddress;
	}

	@Column(name = "companyInfo", nullable = false, length = 200)
	public String getCompanyInfo()
	{
		return this.companyInfo;
	}

	public void setCompanyInfo(String companyInfo)
	{
		this.companyInfo = companyInfo;
	}

	@Column(name = "remarkPoint")
	public Byte getRemarkPoint()
	{
		return this.remarkPoint;
	}

	public void setRemarkPoint(Byte remarkPoint)
	{
		this.remarkPoint = remarkPoint;
	}
	
	
	@Column(name = "recruitmentTime")
	public Integer getRecruitmentTime()
	{
		return this.recruitmentTime;
	}
	
	public void setRecruitmentTime(Integer recruitmentTime)
	{
		this.recruitmentTime = recruitmentTime;
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

	@Column(name = "balance", precision = 22, scale = 0)
	public Double getBalance()
	{
		return this.balance;
	}

	public void setBalance(Double balance)
	{
		this.balance = balance;
	}

	@Column(name = "licenseNum", nullable = false, length = 13)
	public String getLicenseNum()
	{
		return this.licenseNum;
	}

	public void setLicenseNum(String licenseNum)
	{
		this.licenseNum = licenseNum;
	}

	@Column(name = "employerName", nullable = false, length = 50)
	public String getEmployerName()
	{
		return this.employerName;
	}

	public void setEmployerName(String employerName)
	{
		this.employerName = employerName;
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

	@Column(name = "email", length = 50)
	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
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

	@OneToMany(fetch = FetchType.LAZY,mappedBy = "employer")
	public List<Publication> getPublications()
	{
		return this.publications;
	}

	public void setPublications(List<Publication> publications)
	{
		this.publications = publications;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "employer")
	public List<EmployerPayment> getEmployerPayments()
	{
		return this.employerPayments;
	}

	public void setEmployerPayments(List<EmployerPayment> employerPayments)
	{
		this.employerPayments = employerPayments;
	}
	@Override
	public String toString()
	{
		return "Employer [employerId=" + employerId + ", companyName="
				+ companyName + ", city=" + city + ", companyPhone="
				+ companyPhone + ", cellphone=" + cellphone + ", contactName="
				+ contactName + ", companyAddress=" + companyAddress
				+ ", companyInfo=" + companyInfo + ", remarkPoint="
				+ remarkPoint + ", registerTime=" + registerTime
				+ ", balance=" + balance
				+ ", licenseNum=" + licenseNum + ", employerName="
				+ employerName + ", password=" + password + ", email=" + email
				+ ", icon=" + icon + "]";
	}
	
   
}
