package com.juzhituan.controller.employer;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juzhituan.constant.Constants;
import com.juzhituan.domain.License;
import com.juzhituan.service.LicenseService;
import com.juzhituan.util.JSONUtil;

/*
 * 
 * 0）/license/{licenseNum}/{cellphone}       GET      查询许可证信息,验证码
 * */

@Controller
@RequestMapping("/license")
public class LicenseController
{
	@Autowired
	private LicenseService licenseService;
 
	
	/**
	 *  查询许可证
	 *
	 *  @param licenseNum 许可证号     
	 *  @param cellphone  申请手机号  
	 *
	 *  @return  数据格式:JSON，若存在返回许可证信息，否则返回错误信息{"error":{"licenseNum":"许可证不存在"}}
	 *  
	 */

   @RequestMapping(value="/{licenseNum}/{cellphone}",method=RequestMethod.GET)
   public void queryLicense(@PathVariable String licenseNum,@PathVariable String cellphone,
		   HttpServletResponse response) throws IOException
   {
	   License license=licenseService.getLicense(licenseNum,cellphone);
	   if (license==null)
	   {
		   JSONUtil.outputError(Constants.LICENSE_NOT_EXIST, response);
	   }
	   else
	   {
		  JSONUtil.outputLicense(license, response);
	   }
   }
   
   
   
}
