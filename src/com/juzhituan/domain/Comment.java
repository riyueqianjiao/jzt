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
@Table(name = "t_comment", catalog = "juzhituan")
public class Comment implements java.io.Serializable
{

	private Integer commentId;
	private Publication publication;
	private Employee employee;
	private Byte workPoint;
	private Byte salaryPoint;
	private String other;
	private Date   time;

	public Comment()
	{
	}

	public Comment(Publication publication, Employee employee,
			Byte workPoint, Byte salaryPoint)
	{
		this.publication= publication;
		this.employee = employee;
		this.workPoint = workPoint;
		this.salaryPoint = salaryPoint;
	}

	public Comment(Publication publication, Employee employee,
			Byte workPoint, Byte salaryPoint, String other)
	{
		this.publication =publication;
		this.employee =employee;
		this.workPoint = workPoint;
		this.salaryPoint = salaryPoint;
		this.other = other;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "commentId", unique = true, nullable = false)
	public Integer getCommentId()
	{
		return this.commentId;
	}

	public void setCommentId(Integer commentId)
	{
		this.commentId = commentId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publicationId", nullable = false)
	public Publication getPublication()
	{
		return this.publication;
	}

	public void setPublication(Publication publication)
	{
		this.publication =publication;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "employeeId", nullable = false)
	public Employee getEmployee()
	{
		return this.employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	@Column(name = "workPoint", nullable = false)
	public Byte getWorkPoint()
	{
		return this.workPoint;
	}

	public void setWorkPoint(Byte workPoint)
	{
		this.workPoint = workPoint;
	}

	@Column(name = "salaryPoint", nullable = false)
	public Byte getSalaryPoint()
	{
		return this.salaryPoint;
	}

	public void setSalaryPoint(Byte salaryPoint)
	{
		this.salaryPoint = salaryPoint;
	}

	@Column(name = "other", length = 200)
	public String getOther()
	{
		return this.other;
	}

	public void setOther(String other)
	{
		this.other = other;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "time", nullable = false, length = 19)
	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}
	

}
