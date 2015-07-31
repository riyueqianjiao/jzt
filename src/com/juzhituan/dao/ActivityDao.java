package com.juzhituan.dao;

import java.util.List;

import com.juzhituan.domain.Activity;

public interface ActivityDao extends BaseDao<Activity>
{
    public void save(List<Activity> list);
    public void update(Integer publicationId,Integer[] activityIds,Byte state);
    
    public Activity get(Integer activityId);
    public List<Activity> find(Integer publicationId,Byte state);
    public List<Activity> find(Integer employeeId,Integer publicationId);
    
    
    public List<Activity> findByActivityIds(Integer[] activityIds);
    public void update(Integer activityId,Short applyNum,Short applyNumM);
    public void updateForMan(Integer[] activityIdInts,byte type);
    public void updateForOthers(Integer[] activityIdInts,byte type);
}