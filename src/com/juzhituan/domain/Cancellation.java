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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@SuppressWarnings("serial")
@Entity
@Table(name = "t_cancellation", catalog = "juzhituan")
public class Cancellation implements java.io.Serializable
{

	private Integer cancellationId;
	private Publication publication;
	private Activity activity;
	private String reason;
	private Date time;
	private Byte isDone;

	public Cancellation()
	{
		isDone=0;
	}

	public Cancellation(String reason, Date time, Byte isDone)
	{
		this.reason = reason;
		this.time = time;
		this.isDone = isDone;
	}

	public Cancellation(Publication publication,Activity activity,
			String reason, Date time, Byte isDone)
	{
		this.activity = activity;
		this.publication = publication;
		this.reason = reason;
		this.time = time;
		this.isDone = isDone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "cancellationId", unique = true, nullable = false)
	public Integer getCancellationId()
	{
		return this.cancellationId;
	}

	public void setCancellationId(Integer cancellationId)
	{
		this.cancellationId = cancellationId;
	}

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "activityId",nullable=true)
	public Activity getActivity()
	{
		return this.activity;
	}

	public void setActivity(Activity activity)
	{
		this.activity =activity;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "publicationId")
	public Publication getPublication()
	{
		return this.publication;
	}

	public void setPublication(Publication publication)
	{
		this.publication = publication;
	}
	

	@Column(name = "reason", nullable = false, length = 200)
	public String getReason()
	{
		return this.reason;
	}

	public void setReason(String reason)
	{
		this.reason = reason;
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

	@Column(name = "isDone", nullable = false)
	public Byte getIsDone()
	{
		return this.isDone;
	}

	public void setIsDone(Byte isDone)
	{
		this.isDone = isDone;
	}

}
