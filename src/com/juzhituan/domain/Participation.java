package com.juzhituan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_participation", catalog = "juzhituan")
public class Participation implements java.io.Serializable
{

	private Integer participationId;
	private Activity activity;
	private Employee employee;
    private Byte     isDone;           //用户是否完成该项活动

	public Participation()
	{
		this.isDone=0;
	}

	public Participation(Activity activity, Employee employee)
	{
		this.activity =activity;
		this.employee =employee;
		this.isDone=0;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "participationId", unique = true, nullable = false)
	public Integer getParticipationId()
	{
		return this.participationId;
	}

	public void setParticipationId(Integer participationId)
	{
		this.participationId = participationId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activityId", nullable = false)
	public Activity getActivity()
	{
		return this.activity;
	}

	public void setActivity(Activity activity)
	{
		this.activity = activity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "employeeId", nullable = false)
	public Employee getEmployee()
	{
		return this.employee;
	}

	public void setEmployee(Employee employee)
	{
		this.employee = employee;
	}

	@Column(name = "isDone",nullable = false)
	public Byte getIsDone()
	{
		return isDone;
	}
	public void setIsDone(Byte isDone)
	{
		this.isDone = isDone;
	}
	

}
