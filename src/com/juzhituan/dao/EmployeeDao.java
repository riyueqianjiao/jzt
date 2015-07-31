package com.juzhituan.dao;

import com.juzhituan.domain.Employee;

public interface EmployeeDao extends BaseDao<Employee>
{ 
	public Employee findEmployee(String cellphone);
	public Employee findEmployeeByCellPhone(String cellphone,String password);
	public Employee findEmployee(Integer employeeId,String password);
	public void updatePassword(Integer employeeId,String password);
	public void updatePassword(String cellphone,String password);
}
