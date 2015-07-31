package com.juzhituan.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@SuppressWarnings("serial")
@Entity
@Table(name = "t_manager", catalog = "juzhituan")
public class Manager implements java.io.Serializable
{

	private Integer managerId;
	private String city;
	private Byte role;
	private String name;
	private String password;
	private String cellphone;

	public Manager()
	{
		
	}

	public Manager(Integer managerId, String city, Byte role, String name,
			String password, String cellphone)
	{
		this.managerId = managerId;
		this.city = city;
		this.role = role;
		this.name = name;
		this.password = password;
		this.cellphone = cellphone;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "managerId", unique = true, nullable = false)
	public Integer getManagerId()
	{
		return this.managerId;
	}

	public void setManagerId(Integer managerId)
	{
		this.managerId = managerId;
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

	@Column(name = "role", nullable = false)
	public Byte getRole()
	{
		return this.role;
	}

	public void setRole(Byte role)
	{
		this.role = role;
	}

	@Column(name = "name", nullable = false, length = 50)
	public String getName()
	{
		return this.name;
	}

	public void setName(String name)
	{
		this.name = name;
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

	@Column(name = "cellphone", nullable = false, length = 11)
	public String getCellphone()
	{
		return this.cellphone;
	}

	public void setCellphone(String cellphone)
	{
		this.cellphone = cellphone;
	}

}
