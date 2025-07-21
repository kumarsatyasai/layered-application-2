package com.nt;

import java.util.List;       

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.nt.controller.EmployeeController;
import com.nt.model.Employee; 
@SpringBootApplication
public class LayeredApplication3 {

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(LayeredApplication3.class, args);
		EmployeeController employeeController = ctx.getBean("empController", EmployeeController.class);
		
		try
		{
			List<Employee> list = employeeController.showByEmployeesJobs("CLERK", "MANAGER", "SALESMAN");
			
			list.forEach(emp->System.out.println(emp));
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}

}
