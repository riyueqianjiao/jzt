package com.juzhituan.dao;

import java.util.List;

import com.juzhituan.domain.Cancellation;

public interface CancellationDao  extends BaseDao<Cancellation>
{
   public void save(List<Cancellation> list);
}
