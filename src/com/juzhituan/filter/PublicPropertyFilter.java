package com.juzhituan.filter;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.alibaba.fastjson.serializer.PropertyFilter;
import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Employer;
import com.juzhituan.domain.Publication;

public class PublicPropertyFilter  implements PropertyFilter
{
	private static PublicPropertyFilter instance=new PublicPropertyFilter(); 
	private static Map<String,Set<String>> includeProperties;
	
	public static PublicPropertyFilter getInstance()
	{
		return instance;
	}
	
	private PublicPropertyFilter()
	{
		includeProperties=new HashMap<String, Set<String>>();
		
		/*
		 * Employer
		 * */
		Set<String> employerProperties=new HashSet<String>();
		employerProperties.add("icon");
		employerProperties.add("city");
		employerProperties.add("companyName");
		employerProperties.add("companyInfo");
		employerProperties.add("remarkPoint");
		employerProperties.add("recruitmentNum");
		includeProperties.put(Employer.class.getName(), employerProperties);
		
		/* 
		 * Publication
		 * */
		Set<String> publicationProperties=new HashSet<String>();
		publicationProperties.add("publicationId");
		publicationProperties.add("title");
		publicationProperties.add("salary");
		publicationProperties.add("workAddress");
		publicationProperties.add("startDate");
		publicationProperties.add("publicationTime");
		publicationProperties.add("isLong");
		includeProperties.put(Publication.class.getName(),publicationProperties);	
		
		/*
		 * Activity
		 * */
		Set<String> activityProperties=new HashSet<String>();
		activityProperties.add("activityId");
		activityProperties.add("recruitNum");
		activityProperties.add("recruitNumM");
		activityProperties.add("applyNum");
		activityProperties.add("applyNumM");
		activityProperties.add("salary");
		activityProperties.add("workAddress");
		activityProperties.add("workDate");
		activityProperties.add("detail");
		activityProperties.add("isApplicationDone");
		includeProperties.put(Activity.class.getName(),activityProperties);
		
		
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
		if (includeProperties.containsKey(className))
		{
			Set<String> properties=includeProperties.get(className);
			if (properties.contains(name))
			{
				return true;
			}
		}
		return false;
	}
    
}
