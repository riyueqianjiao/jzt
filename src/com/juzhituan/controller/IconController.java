package com.juzhituan.controller;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.juzhituan.constant.Constants;
import com.juzhituan.util.JSONUtil;
import com.juzhituan.vo.User;

@Controller
@RequestMapping("/icon")
public class IconController
{
	/*
	 * 获取图像
	 * */
	@SuppressWarnings("resource")
	@RequestMapping("/{iconName}.{imageType}")
	public void getImageDo(@PathVariable String iconName,@PathVariable String imageType,
			HttpServletRequest request, HttpServletResponse response) throws Exception
	{  
		   String realPath=Constants.ICON_PATH+iconName+"."+imageType;
	       File imageFile = new File(realPath);  
	       InputStream input=null;
		   try
		   {
				input = new FileInputStream(imageFile);
		   }
		   catch (FileNotFoundException e)
		   {  
			   response.setStatus(404);
			   return;
		   }  
	       /*
	        * 图片格式
	        * */
		   String jpg="jpg|JPG|jpeg|JPEG";
		   String gif="gif|GIF";
		   String png="png|PNG";
		   String bmp="bmp|BMP";
		   String contentType="";
		   if (jpg.indexOf(imageType)>=0)
		   {
			  contentType="image/ipeg";
		   }
		   else if(gif.indexOf(imageType)>=0)
		   {
			  contentType="image/gif";
		   }
		   else if (png.indexOf(imageType)>=0)
		   {
			  contentType="image/png";
		   }
		   else if (bmp.indexOf(imageType)>=0)
		   {
			  contentType="image/bmp";
		   }
		   else 
		   {
			   response.setStatus(404);
			   return;
		   }
		
		   response.setContentType(contentType);  
		   input= new FileInputStream(imageFile); 
	       byte data[]=readInputStream(input); 
	       input.close();
	        
	       OutputStream out=response.getOutputStream();  
	       out.write(data);  
	       out.flush();  
	       out.close();  
	    }  
	
	  /*
	   *  从输入流中获取数据
	   * */
	  public static byte[] readInputStream(InputStream inStream) throws Exception
	  {    
         ByteArrayOutputStream outStream = new ByteArrayOutputStream();    
         byte[] buffer = new byte[2048];    
         int len = 0;    
         while( (len=inStream.read(buffer)) != -1 )
         {    
            outStream.write(buffer, 0, len);    
         }    
         byte[] data=outStream.toByteArray();
         inStream.close();   
         outStream.close();
         return data;    
     }
	  
	  
	  /*
	    * 用户上传头像
	    * 命名规则为用户名.图像类型
	    * 保存路径:ICON_PATH
	    * */
	   @RequestMapping(value="/upload",method=RequestMethod.POST)
	   public void uploadDo(HttpServletRequest request,HttpServletResponse response) throws IOException
	   {
		   User user=(User) request.getSession().getAttribute(com.juzhituan.constant.Constants.USER_SESSION_KEY);
		   if (user!=null)
		   {
			 CommonsMultipartResolver multipartResolver=new CommonsMultipartResolver(request.getServletContext());
			 if(multipartResolver.isMultipart(request))
			 {
				MultipartHttpServletRequest multipartHttpServletRequest=(MultipartHttpServletRequest) request;
				MultipartFile file=multipartHttpServletRequest.getFile(Constants.UPLOAD_FILENAME);
				long size=file.getSize();
				String originalFileName=file.getOriginalFilename();
				String fileType=originalFileName.substring(originalFileName.indexOf('.')+1);
				if(size>Constants.MAX_FILESIZE)
				{
					JSONUtil.outputError(Constants.EXCESS_MAX_FILESIZE, response);
					return;
				}
				if(Constants.SUPPORT_FILETYPES.indexOf(fileType)<0)
				{
					JSONUtil.outputError(Constants.ERROR_FILE_TYPE, response);
					return;
				}
				String dstPath=Constants.ICON_PATH;
				String fileName=user.getUserId()+"."+fileType;
			    File localFile=new java.io.File(dstPath+fileName);
			    try
			    {
				   file.transferTo(localFile);
				}
			    catch (IllegalStateException | IOException e)
				{
				   JSONUtil.outputError(Constants.UPLOAD_FAILED, response);
			    }   
		     } 
		   }
		 }
	  
}
