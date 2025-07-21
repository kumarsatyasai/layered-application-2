package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeService {
	
	public List<Employee> fetchByJobs(String job1, String job2, String job3)throws Exception;

}
