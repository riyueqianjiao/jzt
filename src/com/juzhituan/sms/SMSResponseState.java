package com.juzhituan.sms;

public class SMSResponseState
{
    private String state;
    private String description;
    
    public SMSResponseState()
	{
	}
    
	public SMSResponseState(String state, String description)
	{
		super();
		this.state = state;
		this.description = description;
	}

	public String getState()
	{
		return state;
	}
	public void setState(String state)
	{
		this.state = state;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}

	@Override
	public String toString()
	{
		return "SMSResponseState [state=" + state + ", description="
				+ description + "]";
	}
	
	
   
}
