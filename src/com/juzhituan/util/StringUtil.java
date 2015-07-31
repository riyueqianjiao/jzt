package com.juzhituan.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil
{
	private StringUtil()
	{
		
	}
	public static boolean isSatisfyLenght(String str,int minLenght)
	{
	    	int length=str.length();
	    	if (minLenght<=length)
			{
				return true;
			}
	    	return false;
	}
    public static boolean isSatisfyLenght(String str,int minLenght,int maxLength)
    {
    	int length=str.length();
    	if (minLenght<=length&&length<=maxLength)
		{
			return true;
		}
    	return false;
    }
    
    public static boolean isEmail(String email)
    {
    	 String check = "^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$";
         Pattern regex = Pattern.compile(check);
         Matcher matcher = regex.matcher(email);
         return matcher.matches();
    }
    public static boolean isCellphone(String mobile)
    {
	   //Pattern p = Pattern.compile("^((13[0-9])|(15[^4,\\D])|(18[0,5-9]))\\d{8}$");
	   Pattern p = Pattern.compile("^1[3|4|5|7|8][0-9]\\d{8}$");
       Matcher m = p.matcher(mobile);
       return m.matches();   
    }
    public static boolean isDate(String date)
    {
    	Pattern pattern=Pattern.compile("2[0-9]{3}-(0[1-9])|(1[0-2])-(0[1-9])|([1-2][0-9])|(3[0-1])");
    	Matcher matcher=pattern.matcher(date);
    	return matcher.matches();
    }
}
