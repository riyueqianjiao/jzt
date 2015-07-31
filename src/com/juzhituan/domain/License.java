package com.juzhituan.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_license", catalog = "juzhituan")
public class License implements java.io.Serializable
{

	private Integer licenseId;
	private String  licenseNum;
	private Date    generateTime;
	private Byte    isActived;
	private String  companyName;
	private String  contactName;
	private String  cellphone;
	private String  companyPhone;
	private String  city;
	private String  companyAddress;
	private String  companyInfo;

	public License()
	{
		this.isActived=0;
	}

	public License(String licenseNum, Date generateTime, Byte isActived,
			String companyName, String contactName, String cellphone,
			String companyPhone, String city, String companyAddress,
			String companyInfo)
	{
		this.licenseNum = licenseNum;
		this.generateTime = generateTime;
		this.isActived = isActived;
		this.companyName = companyName;
		this.contactName = contactName;
		this.cellphone = cellphone;
		this.companyPhone = companyPhone;
		this.city = city;
		this.companyAddress = companyAddress;
		this.companyInfo = companyInfo;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "licenseId", unique = true, nullable = false)
	public Integer getLicenseId()
	{
		return this.licenseId;
	}

	public void setLicenseId(Integer licenseId)
	{
		this.licenseId = licenseId;
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

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "generateTime", nullable = false, length = 19)
	public Date getGenerateTime()
	{
		return this.generateTime;
	}

	public void setGenerateTime(Date generateTime)
	{
		this.generateTime = generateTime;
	}

	@Column(name = "isActived", nullable = false)
	public Byte getIsActived()
	{
		return this.isActived;
	}

	public void setIsActived(Byte isActived)
	{
		this.isActived = isActived;
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

	@Column(name = "companyPhone", nullable = false, length = 13)
	public String getCompanyPhone()
	{
		return this.companyPhone;
	}

	public void setCompanyPhone(String companyPhone)
	{
		this.companyPhone = companyPhone;
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

	@Column(name = "companyAddress", nullable = false, length = 200)
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

}
