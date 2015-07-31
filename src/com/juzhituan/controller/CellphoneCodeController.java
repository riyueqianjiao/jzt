package com.juzhituan.controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.juzhituan.constant.Constants;
import com.juzhituan.sms.SMS;
import com.juzhituan.util.JSONUtil;
import com.juzhituan.util.StringUtil;


@Controller
public class CellphoneCodeController
{
	/*
	 * 手机验证码
	 * */
	@RequestMapping("/sendCheckCode")
	public void checkCode(String cellphone,
			HttpServletRequest request,HttpServletResponse response) throws IOException
	{		
		if(cellphone==null)
		{
			JSONUtil.outputError("请填写手机号", response);
			return;
		}
		if (!StringUtil.isCellphone(cellphone))
		{
			JSONUtil.outputError(Constants.ERROR_IMAGE_CHECKCODE, response);
			return;
		}
		HttpSession session=request.getSession();
		//获取随机验证码
		String code=getRandomCode();
		session.setAttribute(Constants.CELLPHONE_CODE_SESSION_KEY,code);
		//发送验证码至手机
		SMS.sendCheckCode(cellphone, code);
		JSONUtil.outputStatus(true, response);
	}
	
	/*
	 * 获取随机验证码
	 * */
	private String getRandomCode()
	{
		String code="";
		Random random=new Random();
		for (int i = 0; i < Constants.CHECKCODE_LENGTH; i++)
		{
			code+=random.nextInt(10);
		}
		return code;
	}
}
