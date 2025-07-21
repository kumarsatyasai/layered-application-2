package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.IEmployeeDAO;
import com.nt.model.Employee;


@Service("empService")
public class EmployeeService implements IEmployeeService {
	
	@Autowired
	private IEmployeeDAO empDAO;
	
	

	public EmployeeService() {
		super();
		System.out.println("EmployeeService::0-Param Constructor.");
		
	}



	@Override
	public List<Employee> fetchByJobs(String job1, String job2, String job3) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> list = empDAO.getEmployeesByJobs(job1, job2, job3);
		return list;
	}

}
