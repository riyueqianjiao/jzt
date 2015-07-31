package com.juzhituan.filter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Employee;
import com.juzhituan.domain.Employer;
import com.juzhituan.domain.Publication;

public class PrivatePropertyFilter  implements PropertyFilter
{
	private static PrivatePropertyFilter instance=new PrivatePropertyFilter(); 
	private static Map<String,Set<String>> excludeProperties;
	
	public static PrivatePropertyFilter getInstance()
	{
		return instance;
	}
	private PrivatePropertyFilter()
	{
		excludeProperties=new HashMap<String, Set<String>>();
		/*
		 * Employer
		 * */
		Set<String> employerProperties=new HashSet<String>();
		employerProperties.add("licenseNum");
		employerProperties.add("password");
		employerProperties.add("publications");
		employerProperties.add("employerPayments");
		excludeProperties.put(Employer.class.getName(), employerProperties);
		
		
		/* 
		 * Publication
		 * */
		Set<String> publicationProperties=new HashSet<String>();
		publicationProperties.add("remarks");
		excludeProperties.put(Publication.class.getName(),publicationProperties);
		
		/*
		 * Activity
		 * */
		Set<String> activityProperties=new HashSet<String>();
		activityProperties.add("publication");
		activityProperties.add("participations");
		excludeProperties.put(Activity.class.getName(),activityProperties);
		
		/*
		 * Employee
		 * */
		Set<String> employeeProperties=new HashSet<String>();
		employeeProperties.add("password");
		employeeProperties.add("employeePaids");
		employeeProperties.add("remarks");
		employeeProperties.add("participations");
		excludeProperties.put(Employee.class.getName(), employeeProperties);
		
		
	}
	/**
	 * 过滤不需要被序列化的属性
	 * @param object 属性所在的对象
	 * @param name 属性名
	 * @param value 属性值
	 * @return 返回false属性将被忽略，ture属性将被保留
	 */
	@Override
	public boolean apply(Object object, String name, Object value) 
	{
		String className=object.getClass().getName();
		int index=className.indexOf('_');
		//代理类对象
		if (index>0)
		{
		  className=className.substring(0, index);
		}
		if (excludeProperties.containsKey(className))
		{
			Set<String> properties=excludeProperties.get(className);
			if (properties.contains(name))
			{
				return false;
			}
		}
		return true;
	}
    
}
