package com.juzhituan.controller;

import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.google.code.kaptcha.Producer;
import com.juzhituan.constant.Constants;

@Controller
public class ImageCodeController
{
	@Autowired
	private Producer captchaProducer;  

	/*
	 * 图片验证码
	 * */
	@RequestMapping("/imagecode")
	public void handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception
	{  
	  
	        response.setDateHeader("Expires", 0);  
	        // Set standard HTTP/1.1 no-cache headers.  
	        response.setHeader("Cache-Control", "no-store, no-cache, must-revalidate");  
	        // Set IE extended HTTP/1.1 no-cache headers (use addHeader).  
	        response.addHeader("Cache-Control", "post-check=0, pre-check=0");  
	        // Set standard HTTP/1.0 no-cache header.  
	        response.setHeader("Pragma", "no-cache");  
	        // return a jpeg  
	        response.setContentType("image/jpeg");  
	        // create the text for the image  
	        String codeText = captchaProducer.createText();  
	        // store the text in the session  
	        request.getSession().setAttribute(Constants.IMAGE_CODE_SESSION_KEY, codeText);  
	        // create the image with the text  
	        BufferedImage codeIamge = captchaProducer.createImage(codeText);  
	        ServletOutputStream out = response.getOutputStream();  
	        // write the data out  
	        ImageIO.write(codeIamge, "jpg", out);  
	        try 
	        {  
	            out.flush();  
	        }
	        finally 
	        {  
	            out.close();  
	        } 
	    }  
    
}
