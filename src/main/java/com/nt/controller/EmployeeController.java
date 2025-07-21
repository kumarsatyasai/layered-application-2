package com.nt.controller;

import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.nt.model.Employee;
import com.nt.service.IEmployeeService;

@Controller("empController")
public class EmployeeController {
	
	@Autowired
	private IEmployeeService empService;
	
	
	

	public EmployeeController() {
		super();
		System.out.println("EmployeeController::0-Param Constructor.");
		
	}




	public List<Employee> showByEmployeesJobs(String job1, String job2, String job3)throws Exception
	{
		List<Employee> list = empService.fetchByJobs(job1, job2, job3);
		return list;
	}
	

}
