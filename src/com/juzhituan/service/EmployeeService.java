package com.juzhituan.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.juzhituan.constant.Constants;
import com.juzhituan.dao.ActivityDao;
import com.juzhituan.dao.CommentDao;
import com.juzhituan.dao.EmployeeDao;
import com.juzhituan.dao.ParticipationDao;
import com.juzhituan.dao.PublicationDao;
import com.juzhituan.domain.Activity;
import com.juzhituan.domain.Employee;
import com.juzhituan.domain.Participation;
import com.juzhituan.domain.Publication;
import com.juzhituan.util.EncryptionUtil;


@Service
public class EmployeeService 
{
	@Autowired
  	private EmployeeDao employeeDao;
	@Autowired
	private ActivityDao activityDao;
	@Autowired
	private ParticipationDao participationDao;
	@Autowired
	private PublicationDao publicationDao;
	@Autowired
	private CommentDao commentDao;
  	
    //查询用户是否存在
 	public boolean isEmployeeExisted(String cellphone){
 		Employee employee = employeeDao.findEmployee(cellphone); 
 		if(employee == null)
 		{
 			return false;
 		}else
 			return true;
 	}
  	//查询用户
  	public Employee getEmployee(String cellphone,String password)
  	{
  		return employeeDao.findEmployeeByCellPhone(cellphone, EncryptionUtil.MD5(password));
  	}
  	public Employee getEmployee(Integer employeeId)
    {
 	   return employeeDao.get(Employee.class,employeeId);
    }
  	public Employee getEmployee(Integer employeeId,String password)
  	{
  		return employeeDao.findEmployee(employeeId, EncryptionUtil.MD5(password));
  	}
  	//添加用户
  	public void saveEmployee(Employee employee){
  		{
  		   //密码加密  		   
  		   employee.setPassword(EncryptionUtil.MD5(employee.getPassword()));
  		   //添加注册日期
  	       employee.setRegisterTime(new Date());
  		   employeeDao.save(employee);		  
  	   }
  	}
  	//毫秒转时间
  	public  String formatDuring(long mss) {  
  	    long days = mss / (1000 * 60 * 60 * 24);  
  	    long hours = (mss % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60);  
  	    long minutes = (mss % (1000 * 60 * 60)) / (1000 * 60);  
  	    long seconds = (mss % (1000 * 60)) / 1000;  
  	    return "账号因您取消报名而被锁定，解锁前暂时不能报名，剩余锁定时间为"+days + " days " + hours + " hours " + minutes + " minutes "  
  	            + seconds + " seconds ";  
  	} 
  	
  	//修改密码
  	public void updatePass(Integer employeeId,String password)
  	{
  		employeeDao.updatePassword(employeeId, EncryptionUtil.MD5(password));
  	}
  	public void updatePass(String cellphone,String password)
  	{
  		employeeDao.updatePassword(cellphone, EncryptionUtil.MD5(password));
  	}
  	
  	//更新用户
  	public void updateEmployee(Employee employee,String employeeName,String alipayNum,String gender)
  	{
  		employee.setEmployeeName(employeeName);
  		employee.setAlipayNum(alipayNum);
  		employee.setGender(gender);
  		employeeDao.update(employee);
  	}
  	public void updateEmployee(Employee employee)
  	{
  		employeeDao.update(employee);
  	}
  	
  	//修改头像
  	public void changeIcon(Employee employee,String icon)
  	{
  		employee.setIcon(icon);
  		employeeDao.update(employee);
  	}
  	
  	//获取兼职详情
  	public Activity getActivity(Integer activityId)
  	{
  		return activityDao.get(activityId);
  	}
  	public List<Activity> getActivities(Integer[] activityIds)
  	{
  		return activityDao.findByActivityIds(activityIds);
  	}
  	//查看报名publication中各activity情况
  	public List<Activity> find(Integer employeeId,Integer publicationId)
  	{
  		List<Activity> activities = activityDao.find(employeeId, publicationId);
  		return activities;
  	}
  	//查看自己已报名情况
  	public List<Participation> getParticipation(Integer employeeId)
  	{
  		return participationDao.findParticipationByEmployeeId(employeeId);
  	}
  	public Participation getParticipationByActivityId(Integer employeeId,Integer activityId)
  	{
  		return participationDao.findParticipationByActivityId(employeeId,activityId);
  	}
  	public List<Participation> getParticipationByWorkDate(Date workDate)
  	{
  		return participationDao.findParticipationByWorkDate(workDate);
  	}
  	public Long getParticipationByWorkDates(Integer employeeId,Date[] workDates)
  	{
  		return participationDao.findParticipationByWorkDates(employeeId, workDates);
  	}
  	//报名
  	public void signupForMan(Employee employee,List<Activity> activities,Integer[] activityIdInts)
  	{
  		activityDao.updateForMan(activityIdInts,Constants.SIGNUP);	
  		List<Participation> participations = new ArrayList<Participation>();
  		for(int i =0;i<activities.size();i++)
  		{
  			Participation participation = new Participation();
  			participation.setActivity(activities.get(i));
			participation.setEmployee(employee);
			participations.add(participation);
  		}	
  		participationDao.save(participations);	
  	}
  	
  	public void signupForOthers(Employee employee,List<Activity> activities,Integer[] activityIdInts)
  	{
  		activityDao.updateForOthers(activityIdInts,Constants.SIGNUP);
  		List<Participation> participations = new ArrayList<Participation>();
  		for(int i =0;i<activities.size();i++)
  		{
  			Participation participation = new Participation();
  			participation.setActivity(activities.get(i));
			participation.setEmployee(employee);
			participations.add(participation);
  		}	
  		participationDao.save(participations);
  	}
  	
  	//取消报名
  	public void cancelSignupForMan(Employee employee,Integer[] activityIdInts)
  	{
  		activityDao.updateForMan(activityIdInts,Constants.CANCELSIGNUP);
  		employee.setIsLocked((byte)(1));
		employee.setLastLockedTime(new Date());
		employeeDao.update(employee); 
		List<Participation> participations= participationDao.findParticipationByActivityId(employee.getEmployeeId(), activityIdInts);
		participationDao.deleteAll(participations);
  	}
  	public void cancelSignupForOthers(Employee employee,Integer[] activityIdInts)
  	{
  		activityDao.updateForOthers(activityIdInts,Constants.CANCELSIGNUP);
  		employee.setIsLocked((byte)(1));
		employee.setLastLockedTime(new Date());
		employeeDao.update(employee); 
		List<Participation> participations= participationDao.findParticipationByActivityId(employee.getEmployeeId(), activityIdInts);
		participationDao.deleteAll(participations);	
  	}

  	
  //查看报名总次数
  	public Long getPublicationTotalNum(Integer employeeId)
  	{
  		return publicationDao.getTotalNum(employeeId);
  	}
  	
  	//分页查看报名情况
  	public List<Publication> findByPage(Integer employeeId,Integer pageNum)
    {
 	   if (pageNum==null)
 	   {
 		  pageNum=1;
 	   }
 	   return publicationDao.findByPage(employeeId, pageNum);
 	   
    }

  	 //查看已完成兼职次数
  	public Long getIsDonePublicationTotalNum(Integer employeeId)
  	{
  		return publicationDao.getIsDoneTotalNum(employeeId);
  	}
  	
  	//分页查看
  	public List<Publication> findIsDoneByPage(Integer employeeId,Integer pageNum)
    {
 	   if (pageNum==null)
 	   {
 		  pageNum=1;
 	   }
 	   return publicationDao.findIsDoneByPage(employeeId, pageNum);
 	   
    }
 
  	
}	
  	
