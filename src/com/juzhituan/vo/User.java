package com.juzhituan.vo;


public class User
{
	private Integer userId;
	private String  userName;
	private Byte userType; 
	
	public User()
	{
		
	}
	
	public User(Integer userId, String userName, Byte userType)
	{
		this.userId = userId;
		this.userName = userName;
		this.userType = userType;
	}
	
	public Integer getUserId()
	{
		return userId;
	}
	public void setUserId(Integer userId)
	{
		this.userId = userId;
	}
	public String getUserName()
	{
		return userName;
	}
	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public Byte getUserType()
	{
		return userType;
	}

	public void setUserType(Byte userType)
	{
		this.userType = userType;
	}
	
	
}
