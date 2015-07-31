package com.juzhituan.dao;

import java.util.List;

import com.juzhituan.domain.Publication;


public interface PublicationDao extends BaseDao<Publication>
{
	 /*
	  * */
	 public Publication get(Integer publicationId,Boolean isLazy);
	 public Boolean update(Integer publibcationId,Byte state);
	 public Boolean update(Integer[] publibcationIds,Byte state);
	 /*
	  * 
	  * */
	 public Long getTotalNum(String area,Byte workType,String searchKey);
	 public List<Publication> findByPage(String area,Byte workType,String searchKey,Integer pageNum,Byte orderType);
	 
	
	 /*
	  * 
	  * */
	 public Long getTotalNum(Integer employerId,Byte state);
	 public List<Publication> findByPage(Integer employerId,Integer pageNum,Byte orderType,Byte state);
	 public Publication get(Integer employerId,Integer publibcationId,Boolean isLazy);
	 
	 /*
	  * 
	  * */
	 public Long getTotalNum(Integer employeeId);
	 public List<Publication> findByPage(Integer employeeId,Integer pageNum);
	 public Long getIsDoneTotalNum(Integer employeeId);
	 public List<Publication> findIsDoneByPage(Integer employeeId,Integer pageNum);
}
