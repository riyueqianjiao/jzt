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
@Table(name = "t_employeePaid", catalog = "juzhituan")
public class EmployeePaid implements java.io.Serializable
{

	private Integer employeePayedId;
	private Employee employee;
	private String salipayNum;
	private String dalipayNum;
	private Integer amount;
	private Date time;

	public EmployeePaid()
	{
	}

	public EmployeePaid(Employee employee, String salipayNum,
			String dalipayNum, Integer amount, Date time)
	{
		this.employee = employee;
		this.salipayNum = salipayNum;
		this.dalipayNum = dalipayNum;
		this.amount = amount;
		this.time = time;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "employeePayedId", unique = true, nullable = false)
	public Integer getEmployeePayedId()
	{
		return this.employeePayedId;
	}

	public void setEmployeePayedId(Integer employeePayedId)
	{
		this.employeePayedId = employeePayedId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable = false)
	public Employee getEmployee()
	{
		return this.employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee =employee;
	}

	@Column(name = "sAlipayNum", nullable = false, length = 50)
	public String getSalipayNum()
	{
		return this.salipayNum;
	}

	public void setSalipayNum(String salipayNum)
	{
		this.salipayNum = salipayNum;
	}

	@Column(name = "dAlipayNum", nullable = false, length = 50)
	public String getDalipayNum()
	{
		return this.dalipayNum;
	}

	public void setDalipayNum(String dalipayNum)
	{
		this.dalipayNum = dalipayNum;
	}

	@Column(name = "amount", nullable = false)
	public Integer getAmount()
	{
		return this.amount;
	}

	public void setAmount(Integer amount)
	{
		this.amount = amount;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime()
	{
		return this.time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}

}
