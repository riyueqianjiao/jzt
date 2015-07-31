package com.juzhituan.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_employerPayment", catalog = "juzhituan")
public class EmployerPayment implements java.io.Serializable
{

	private Integer paymentId;
	private Employer employer;
	private String sbankCardNum;
	private String sbankName;
	private String dbankCardNum;
	private Integer amount;
	private Date paymentTime;

	public EmployerPayment()
	{
	}

	public EmployerPayment(Employer employer, String sbankCardNum,
			String sbankName, String dbankCardNum, Integer amount,
			Date paymentTime)
	{
		this.employer = employer;
		this.sbankCardNum = sbankCardNum;
		this.sbankName = sbankName;
		this.dbankCardNum = dbankCardNum;
		this.amount = amount;
		this.paymentTime = paymentTime;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "paymentId", unique = true, nullable = false)
	public Integer getPaymentId()
	{
		return this.paymentId;
	}

	public void setPaymentId(Integer paymentId)
	{
		this.paymentId = paymentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employerId", nullable = false)
	public Employer getEmployer()
	{
		return this.employer;
	}

	public void setEmployer(Employer employer)
	{
		this.employer = employer;
	}

	@Column(name = "sBankCardNum", nullable = false, length = 19)
	public String getSbankCardNum()
	{
		return this.sbankCardNum;
	}

	public void setSbankCardNum(String sbankCardNum)
	{
		this.sbankCardNum = sbankCardNum;
	}

	@Column(name = "sBankName", nullable = false, length = 20)
	public String getSbankName()
	{
		return this.sbankName;
	}

	public void setSbankName(String sbankName)
	{
		this.sbankName = sbankName;
	}

	@Column(name = "dBankCardNum", nullable = false, length = 19)
	public String getDbankCardNum()
	{
		return this.dbankCardNum;
	}

	public void setDbankCardNum(String dbankCardNum)
	{
		this.dbankCardNum = dbankCardNum;
	}

	@Column(name = "amount", nullable = false)
	public Integer getAmount()
	{
		return this.amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount =amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "paymentTime", nullable = false, length = 19)
	public Date getPaymentTime()
	{
		return this.paymentTime;
	}

	public void setPaymentTime(Date paymentTime)
	{
		this.paymentTime = paymentTime;
	}

}
