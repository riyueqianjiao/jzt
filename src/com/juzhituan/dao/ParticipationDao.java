package com.juzhituan.dao;

import java.util.Date;
import java.util.List;

import com.juzhituan.domain.Participation;

public interface ParticipationDao extends BaseDao<Participation>
{
	public List<Participation> findParticipationByEmployeeId(Integer employeeId);
	public Participation findParticipationByActivityId(Integer employeeId,Integer activityId);
	public List<Participation> findParticipationByWorkDate(Date workDate);
	public Long findParticipationByWorkDates(Integer employeeId,Date[] workDates);
	public List<Participation> findParticipationByActivityId(Integer employeeId,Integer[] activityIds);
	public void save(List<Participation> participations); 
	public void deleteAll(List<Participation> participations); 

}
