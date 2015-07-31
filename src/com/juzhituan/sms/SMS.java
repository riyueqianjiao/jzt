package com.juzhituan.sms;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

public class SMS
{
	private static String uid="106376";
	private static String pwd="c346c9399c06eda02d35e1783f7bfa83"; 
	private static String encode="utf8";
    private static String baseUrl="http://api.cnsms.cn/";
    
    private static SMSResponseState sendPost(String mobile,String content)
    {
    	PrintWriter out = null;
  	    BufferedReader in = null;
  	    SMSResponseState state=null;
  	    try
  	    {
  	      content=URLEncoder.encode(content,encode);
  	      StringBuffer param=new StringBuffer();
  	      param.append("ac=send&")
  	           .append("uid="+uid+"&")
  	           .append("pwd="+pwd+"&")
  	           .append("encode="+encode+"&")
  	           .append("mobile="+mobile+"&")
  	           .append("content="+content);
  	      URL url= new URL(baseUrl);
  	      URLConnection conn = url.openConnection();
  	      conn.setRequestProperty("accept", "*/*"); 
  	      conn.setRequestProperty("connection", "Keep-Alive"); 
  	      conn.setRequestProperty("user-agent", "Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 5.1; SV1)"); 
  	      //发送POST请求
  	      conn.setDoOutput(true);
  	      conn.setDoInput(true);
  	      out = new PrintWriter(conn.getOutputStream());
  	      //发送请求参数
  	      out.print(param);
  	      out.flush();
  	      //读取响应
  	      in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
  	      String line;
  	      String result="";
  	      while ((line = in.readLine())!= null)
  	      {
  	        result+= line;
  	      }
  	      if ("100".equals(result))
		  {
		     state=new SMSResponseState("100", "发送成功");  	
		  }
  	      else if("106".equals(result))
  	      {
  	    	  state=new SMSResponseState("106", "号码过多");
  	      }
  	      else if("107".equals(result))
  	      {
  	    	 state=new SMSResponseState("107", "发送频率过快");
  	      }
  	      else if("110".equals(result))
  	      {
  	    	 state=new SMSResponseState("110", "频繁单条发送");
  	      }
  	      else if("112".equals(result))
  	      {
  	    	 state=new SMSResponseState("112","号码错误");
  	      }
  	      else
  	      {
			 state=new SMSResponseState("121", "网络错误，请稍后再试");
		  }
  	 }
  	catch(Exception e){}
  	finally
  	{
  	    try
  	   {
  	     if (out != null)
  	     {
  	       out.close();
  	     }
  	     if (in != null)
  	     {
  	       in.close();
  	     }
  	   }
  	   catch (IOException ex)
  	  {
  	    ex.printStackTrace();
  	  }
    }
    return state;
   }
    
    public static SMSResponseState sendCheckCode(String mobile,String checkCode)
    {
       String content="您的验证码是："+checkCode+"。工作人员绝对不会向您索要，请妥善保管切勿泄露。";
       return sendPost(mobile,content);
    }
    
    public static SMSResponseState sendApplicationSuccess(String mobile)
    {
    	String content="您已报名成功！请登录个人中心查看，请注意工作时间和工作地址。";
    	return sendPost(mobile, content);
    }
    
    public static SMSResponseState sendPublicationSuccess(String mobile)
    {
    	String content="您的招聘信息已经发布成功，请登录个人中心查看。";
    	return sendPost(mobile, content);
    }
    
    
   
    /*
    private  static boolean sendSMS(String[]mobiles,String content)
	{
    	//单次最多发2000条
    	if (mobiles.length>2000)
		{
			return false;
		}
    	StringBuffer buffer=new StringBuffer();
    	int length=mobiles.length;
    	for(int i=length-1;i>0;i--)
    	{
    		buffer.append(mobiles[i]).append(",");
    	}
    	buffer.append(mobiles[0]);
    	System.out.println(buffer.toString());
    	return true;
		//return sendPost(buffer.toString(), content);
	}
	*/
    
}
