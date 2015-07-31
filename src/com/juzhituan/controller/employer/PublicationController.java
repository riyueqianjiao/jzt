package com.juzhituan.controller.employer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.juzhituan.constant.Constants;
import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Publication;
import com.juzhituan.service.PublicationService;
import com.juzhituan.util.JSONUtil;
import com.juzhituan.validator.PublicationValidator;
import com.juzhituan.vo.User;



/**  ******************   公有操作   *******************************************
 *  1）/publication/{publicationId}                        GET      查询某一信息
 *  2）/publication/page/{pageNum}                         GET      分页查询（默认排序）
 *  3）/publication/page/{pageNum}/{orderType}             GET      分页查询（指定排序）
 *  
 *  
 *  ****************   私有操作   **********************************************
 *  4）/publication/private/page/{pageNum}/{state}           GET      分页查询
 *  5）/publication/show/{type}                              GET      查询该公司发布的所有信息
 *  6）/publication/detail/{publicationId}                   GET      查询该公司发布的某一信息
 *  
 *  7）/publication/add                                      GET      发布请求
 *  8）/publication/add                                      POST     处理发布请求
 *  
 *  9）/publication/update/{publicationId}                   GET      更新请求
 *  10）/publication/update/{publicationId}                  POST     处理更新请求
 *  
 *  
 *  11）/publication/applycancel                             GET      申请取消
 *  12）/publication/applycancel/{publicationId}             POST     处理取消请求
 *  
 *  13）/publication/delete/{publicationId}                  POST     处理删除请求
 *
 * */

@Controller
@RequestMapping("/publication")
public class PublicationController
{
	 @Autowired
	 private PublicationService publicationService;
	
	 /*
	  ************************** 公有操作****************************
	  * */
	 
	 /*
	  * 查询商家的已发布的信息
	  * */
	 /*
	 @RequestMapping(method=RequestMethod.GET)
	 public void publicQueryAllDo(HttpServletResponse response) throws IOException
	 {
		Long totalNum=employerService.getPublicationTotalNum();
		if (totalNum>0)
		{
			List<Publication> publications=employerService.findByPage(1);
	        JSONUtil.outputIndexData(new String[]{"totalNum","publications"},
	        		            new Object[]{totalNum,publications},
	        		            response);
		}
		else
		{
		   JSONUtil.outputError(Constants.RESULT_IS_EMPTY, response);	
		}
		
	 }*/
	 
	 
	 /**
	  * 
	  * 请求某一发布信息
	  * publicationId:
	  * */
     @RequestMapping(value="/{publicationId}",method=RequestMethod.GET)
     public String publicQueryDo(@PathVariable Integer publicationId,HttpServletRequest request)
     {
    	 Publication publication=null;
    	 if (publicationId>=0)
		 {
    		 publication=publicationService.getPublication(publicationId, false);
		 }
    	 
    	 /*
    	 if (publication!=null)
		 {
    		 JSONUtil.outputPublicData("publication",publication,response);
		 }
    	 else 
    	 {
		   JSONUtil.outputError(Constants.PUBLICATION_NOT_EXIST,response);	
		 }
		 */
    	 
    	 request.setAttribute("publication",publication);
       	 return "detail";
     }
     
     
	 /*
	  *  分页请求发布信息，默认区域为上海市
	  *  p:省、直辖市
	  *  c:城市
	  *  d:区域
	  * */
	// @RequestMapping(value="/page/{pageNum}",method=RequestMethod.GET)
	 public void publicPageDo(@PathVariable Integer pageNum, String p,String c,String d,HttpServletResponse response) throws IOException
	  {
		 String area=null;
		 if (p==null||p.length()==0)
		 {
			p="上海";
		 }
		 if (c==null||c.length()==0)
		 {
			c="上海";
		 }
		 if (d==null||d.length()==0)
		 {
		   d="全部";	
		   area=p+c;
		 }
		 else
		 {
		   area=p+c+d;	
		 }
		 if (pageNum==null||pageNum<1)
		 {
		    pageNum=1;
		 }
		 List<Publication> publications=publicationService.findByPage(area,pageNum,Constants.ORDER_BY_PUBLICATION_TIME);
		 if (publications==null||publications.size()==0)
		 {
			JSONUtil.outputError(Constants.RESULT_IS_EMPTY,response);
		 }
		 else
		 {
			 JSONUtil.outputPublication(publications,true,response);
		 }
	 }
	 
	 
	// @RequestMapping(value="/page/{pageNum}/{orderType}",method=RequestMethod.GET)
	 public void publicPageDo(@PathVariable Integer pageNum,@PathVariable Byte orderType,String p,String c,String d, HttpServletResponse response) throws IOException
	  {
		 
		 String area=null;
		 if (p==null||p.length()==0)
		 {
			p="上海";
		 }
		 if (c==null||c.length()==0)
		 {
			c="上海";
		 }
		 if (d==null||d.length()==0)
		 {
		   d="全部";	
		   area=p+c;
		 }
		 else
		 {
		   area=p+c+d;	
		 }
		 if (pageNum==null||pageNum<1)
		 {
		   pageNum=1;
		 }
		 if (orderType==null||orderType<0||orderType>4)
		 {
		   orderType=0;
		 }
		 
		 List<Publication> publications=publicationService.findByPage(area,pageNum,orderType);
		 if (publications==null||publications.size()==0)
		 {
			JSONUtil.outputError(Constants.RESULT_IS_EMPTY,response);
		 }
		 else
		 {
			JSONUtil.outputPublication(publications,true,response);
		 }
		 
	 }
	
	 
	 
	/*
	 * ******************************私有操作***************************************
	 * */
	 
	 /*
	  * 分页请求登陆商家的发布信息
	  * */
	 @RequestMapping(value="/private/page/{pageNum}/{state}",method=RequestMethod.GET)
	 public void pageDo(@PathVariable Integer pageNum,@PathVariable Byte state,
			 HttpServletRequest request,HttpServletResponse response) throws IOException
	  {
		 
		 if (pageNum==null||pageNum<0)
		 {
		   pageNum=1;	
	 	 }
		 User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		 Integer employerId=user.getUserId();
		 List<Publication> publications=publicationService.findByPage(employerId,pageNum,state);
		 if (publications==null||publications.size()==0)
		 {
			JSONUtil.outputError(Constants.RESULT_IS_EMPTY,response);
		 }
		 else
		 {
			 JSONUtil.outputPublication(publications,false,response);
	     }
	 }
	 
	 
    /*
     * 获取商家发布信息
     * */
	  @RequestMapping(value="/show/{state}",method=RequestMethod.GET)
	  public String queryAllDo(@PathVariable Byte state,HttpServletRequest request,HttpServletResponse response) throws IOException
	  {
		  /*
		  User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		  Integer employerId=user.getUserId();
		  Long totalNum=publicationService.getPublicationTotalNum(employerId, type);
	      if (totalNum>0)
		  {
			  List<Publication> publications=publicationService.findByPage(employerId,1,type);
			  JSONUtil.outputInfo("num", totalNum+"", response);
		  }
	      else 
	      {
		     JSONUtil.outputError(Constants.RESULT_IS_EMPTY,response);

		   } 
		   */
		
		  User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		  Integer employerId=user.getUserId();
		  Long totalNum=publicationService.getPublicationTotalNum(employerId,state);
		  if (totalNum>0)
		  {
			  List<Publication> publications=publicationService.findByPage(employerId,1,state);
			  request.setAttribute("totalNum",totalNum);
			  request.setAttribute("publications",publications);
		  }
		  String page="employer/yfbzw";
		  if (state==Constants.PUBLICATION_STATE_WORK_DONE)
		  {
			 page="employer/ywjzw";
		  }
		  else if (state==Constants.PUBLICATION_STATE_CANCELED)
		  {
		     page="employer/yqxzw";
		  }
		  
		  return page;  
	  }
	  
	  @RequestMapping(value="/detail",method=RequestMethod.GET)
		 public String detail()
		 {
			 return "employer/detail";
		 }
	  
	 /*
	  * 详情
	  * */
     @RequestMapping(value="detail/{publicationId}",method=RequestMethod.GET)
     public void queryDo(@PathVariable Integer publicationId,HttpServletRequest request,HttpServletResponse response) throws IOException
     {
    	  if (publicationId==null||publicationId<0)
		  {
    		  JSONUtil.outputError(Constants.PUBLICATION_NOT_EXIST,response);	
    		  return;
		  }
    	  User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
		  Integer employerId=user.getUserId();
		  Publication publication=publicationService.getPublication(employerId, publicationId, false);
		  if (publication!=null)
		  {
			  SimpleDateFormat formatDate = new SimpleDateFormat("yyyy-MM-dd");
			  List<Activity> activities=publication.getActivities();
			  int size=activities.size()-1;
			  StringBuffer buffer=new StringBuffer();
			  StringBuffer buffer2=new StringBuffer();
			  buffer2.append("\"recruitmentTime\":\""+publication.getRecruitmentTime()+"\",");
			  buffer2.append("\"title\":\""+publication.getTitle()+"\",");
			  buffer2.append("\"salary\":\""+publication.getSalary()+"\",");
			  buffer2.append("\"requirement\":\""+publication.getRequirement()+"\",");
			  buffer2.append("\"workAddress\":\""+publication.getWorkAddress()+"\",");
			  buffer2.append("\"startDate\":\""+publication.getStartDate()+"\",");
			  buffer2.append("\"workDuration\":\""+publication.getWorkDuration()+"\",");
			  buffer2.append("\"workTimeInfo\":\""+publication.getWorkTimeInfo()+"\",");
			  buffer2.append("\"publicationTime\":\""+publication.getPublicationTime()+"\",");
			  buffer2.append("\"isLong\":"+publication.getIsLong());
			  buffer.append("[");
			  for (int i=0;i<=size;i++)
			  {
				Activity activity=activities.get(i);
				int id=activity.getActivityId();
				String date=formatDate.format(activity.getWorkDate());
				int  recruitNum=activity.getRecruitNum();
				int  applyNum=activity.getApplyNum();
				buffer.
				append("{").
				append("\"date\":\""+date+"\",").
				append("\"activityId\":"+id+",").
				append("\"recruitNum\":"+recruitNum+",").
				append("\"applyNum\":"+applyNum+"}");
				if (i!=size)
				{
					buffer.append(",");
				}
			  }
			  buffer.append("]");
			  String json="{\"status\":\"ok\","+"\"activities\":"+buffer.toString()+","+buffer2.toString()+"}";
			  response.setContentType("application/json;charset=UTF-8");
			  response.getWriter().write(json);
			  response.getWriter().flush();
		  }
		  else 
		  {
			  JSONUtil.outputError(Constants.PUBLICATION_NOT_EXIST,response);	
		  }
		      
     }
     

     
	 @RequestMapping(value="/add",method=RequestMethod.GET)
	 public String publication()
	 {
		 return "employer/fbzw";
	 }
	 
     /*
	  *  商家发布工作
	  *  1）验证数据
	  *  2）数据合法，添加数据，返回提示信息
	 * */
      @RequestMapping(value="/add",method=RequestMethod.POST)
      public void publicationDo(Publication publication, String startTime,
    		  Short recruitNum,Short maleNum,String mes,
    		  HttpServletRequest request,HttpServletResponse response) throws ParseException, IOException
     {

         Map<String, String> error=PublicationValidator.parsePublication(publication,startTime,recruitNum,maleNum,mes);
         if(error!=null&&error.size()>0)
   	     {
   		   JSONUtil.outputError(error, response);
   	     }
   	     else
   	     {
   	        User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
     	    publicationService.savePublication(user.getUserId(),publication); 
     	    JSONUtil.outputStatus(true, response);
		 }
   	      
   	} 
      
      @RequestMapping(value="/applycancel",method=RequestMethod.GET)
      public String applyCancel()
	  {
    	  return "employer/applycancel";
	  }
      /*
       * 取消发布
       * id="publicationId,activityId1,activityId2,...."
       * 若只有publicationId,意味着取消整个活动；否则，只取消部分活动
       * */
      @RequestMapping(value="/applycancel",method=RequestMethod.POST)
      public void applyCancelDo(String id,String reason,
    		  HttpServletRequest request,HttpServletResponse response) throws IOException
      {
    	  //取消原因
    	  if (reason==null||reason.trim().isEmpty())
		  {
    		  JSONUtil.outputError("请填写取消原因", response);
    		  return;
		  }
    	  //解析参数
    	  String[] ids=id.split(",");
    	  Integer publicationId=null;
    	  boolean isAll=false;
    	  Integer[] activityIds=new Integer[ids.length-2];
    	  try
		  {
    		  publicationId=Integer.parseInt(ids[0]);
    		  if (Integer.parseInt(ids[1])==1)
			  {
				isAll=true;
			  }
    		  for (int i = 2; i < ids.length; i++)
    		  {
    			 activityIds[i-2]=Integer.parseInt(ids[i]);
       	   	  }
		  }
    	  catch (NumberFormatException e)
		  {
    		  JSONUtil.outputError("数据格式错误", response);
    		  return;
		  }
    	  //获取要取消的发布信息
    	  User user=(User) request.getSession().getAttribute(Constants.USER_SESSION_KEY);
    	  Integer employerId=user.getUserId();
    	  
    	  if (publicationService.applyCancelPublication( employerId,publicationId,isAll,activityIds,reason))
		  {
			JSONUtil.outputStatus(true, response);
		  }
    	  else
    	  {
			JSONUtil.outputStatus(false, response);
		  }
      }
    
}
