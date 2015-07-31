package com.juzhituan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juzhituan.constant.Constants;
import com.juzhituan.dao.ActivityDao;
import com.juzhituan.dao.CancellationDao;
import com.juzhituan.dao.EmployerDao;
import com.juzhituan.dao.PublicationDao;
import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Cancellation;
import com.juzhituan.domain.Employer;
import com.juzhituan.domain.Publication;


@Service
public class PublicationService
{
   @Autowired
   private EmployerDao employerDao;
   @Autowired
   private PublicationDao publicationDao;
   @Autowired
   private ActivityDao activityDao;
   @Autowired
   private CancellationDao cancellationDao;
    
   
   /*
    * 保存兼职信息
    * */
   public void savePublication(Integer employerId,Publication publication)
   {
	   Employer employer=employerDao.get(Employer.class, employerId);
	   int recruitmentTime=employer.getRecruitmentTime()+1;
	   employer.setRecruitmentTime(recruitmentTime);
	   
	   Date publicatTime=new Date();
	   publication.setEmployer(employer);
	   publication.setPublicationNum(publicatTime.getTime()+publication.getCellphone().substring(7));
	   publication.setCompanyName(employer.getCompanyName());
	   publication.setRecruitmentTime(recruitmentTime);
	   publication.setPublicationTime(publicatTime);
	   employerDao.update(employer);
	   publicationDao.save(publication);
	   activityDao.save(publication.getActivities());
   }
   
   /*
    * 更新兼职
    * */
   
   public void updatePublicaion(Publication publication)
   {
	   publicationDao.update(publication);
   }
   
   
   /*
    * 申请取消
    * 若activityIds为空，则取消整个活动；否则，只取消部分活动
    * */
   public boolean applyCancelPublication(Integer employerId,Integer publicationId,Boolean isAll,Integer[] activityIds,String reason)
   {
	   Publication publication= getPublication(employerId, publicationId,true);
	   if (publication==null)
	   {
		  return false;
	   }
	   if (isAll)
	   {
		  //取消整个活动
		  if (publicationDao.update(publicationId,Constants.PUBLICATION_STATE_CANCELING))
		  {
			 Cancellation cancellation=new Cancellation(publication,null, reason, new Date(),(byte) 0);
			 cancellationDao.save(cancellation);
		  } 
	   }
	   else 
	   {
		   if (activityIds==null)
		  {
			return false;
		  }
		  //取消部分活动
		  List<Cancellation> list=new ArrayList<Cancellation>(activityIds.length);
		  Date date=new Date();
		  for (int i = 0; i < activityIds.length; i++)
		  {
			 Activity activity=new Activity(activityIds[i]);
			 Cancellation cancellation=new Cancellation(publication,activity,reason,date,(byte)0);
			 list.add(cancellation);
		  }
		  activityDao.update(publicationId, activityIds, Constants.PUBLICATION_STATE_CANCELING);
		  cancellationDao.save(list);
	   }
	  return true;
   }
   
   
   /*
    * 取消整个活动或部分活动
    * 若activityIds为空，则取消整个活动；否则，只取消部分活动
    * */
   /*
   public boolean cancelPublication(Integer publicationId,Integer employerId,List<Integer> activitiesId)
   {
	   Publication publication= getPublication(employerId, publicationId,true);
	   if (publication==null)
	   {
		  return false;
	   }
	   //取消整个活动
	   if (activitiesId==null||activitiesId.size()==0)
	   {
		  List<Activity> activities=activityDao.find(publicationId,Constants.PUBLICATION_STATE_ACTIVE);
		  activitiesId=new ArrayList<Integer>(activities.size());
		  for (Activity activity : activities)
		  {
			activitiesId.add(activity.getActivityId());
		  }
		  publication.setState(Constants.PUBLICATION_STATE_CANCELED);
		  publicationDao.update(publication);
	  }
	  activityDao.update(publicationId, activitiesId, Constants.PUBLICATION_STATE_CANCELED);  
	  return true;    
    }
   */
   
   
   
   /*
    * 获得可报名兼职的总数
    * */
   public Long getPublicationTotalNum(String area)
   {
	   return publicationDao.getTotalNum(area, null, null);
   }
   
   public Long getPublicationTotalNum(String area,Byte workType)
   {
	   return publicationDao.getTotalNum(area,workType,null);
   }
   
   public Long getPublicationTotalNum(String area,Byte workType,String searchKey)
   {
	   return publicationDao.getTotalNum(area,workType,searchKey);
   }
   
   
   /* 
    *  分页查询可报名兼职信息
    * */
   public List<Publication> findByPage(String area,Integer pageNum,Byte orderType)
   {
   	    return publicationDao.findByPage(area,null,null,pageNum,orderType);
   }
   
   public List<Publication> findByPage(String area,Byte workType,Integer pageNum,Byte orderType)
   {
	   return publicationDao.findByPage(area,workType,null,pageNum,orderType);
   }
   
   public List<Publication> findByPage(String area,Byte workType,String searchKey,Integer pageNum,Byte orderType)
   {
	   return publicationDao.findByPage(area,workType,searchKey,pageNum,orderType);
   }
   
   /*
    * 具体获得某条兼职信息
    * */
   public Publication getPublication(Integer publicationId,Boolean isLazy)
   {
	   return publicationDao.get(publicationId, isLazy);
   }
   
   public Publication getPublication(Integer employerId,Integer publicationId,Boolean isLazy)
   {
	   return publicationDao.get(employerId, publicationId, isLazy);
   }
   
   
   /*
    * 获得某公司发布的兼职信息总数
    * */
   public Long getPublicationTotalNum(Integer employerId,Byte publicationState)
   {
	   return publicationDao.getTotalNum(employerId, publicationState);
   }
   
   public List<Publication> findByPage(Integer employerId,Integer pageNum,Byte publicationState)
   {
	   return publicationDao.findByPage(employerId, pageNum,Constants.ORDER_BY_PUBLICATION_TIME,publicationState);
	   
   }
   
}
