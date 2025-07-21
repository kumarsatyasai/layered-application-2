package com.nt.dao;
 
import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.nt.model.Employee;

@Repository("mysqlempDAO")
@Profile({"dev", "test"})
public class MySqlEmployeeDAO implements IEmployeeDAO {
	
	private static final String GET_EMPS_BY_JOBS = "SELECT EMPNO,ENAME,JOB,SAL,DEPTNO FROM EMPLOYEE WHERE JOB IN(?,?,?) ORDER BY JOB"; 

	@Autowired
	private DataSource ds;
	
	public MySqlEmployeeDAO() {
		super();
		System.out.println("MySqlEmployeeDAO::0-Param Constructor.");
		
	}

	@Override
	public List<Employee> getEmployeesByJobs(String job1, String job2, String job3) throws Exception {
		// TODO Auto-generated method stub
		List<Employee> list = null;
		
		try(Connection con = ds.getConnection();PreparedStatement ps = con.prepareStatement(GET_EMPS_BY_JOBS);)
		{
			ps.setString(1, job1);
			ps.setString(2, job2);
			ps.setString(3, job3);
		
			
			list = new ArrayList<Employee>();
			
			try(ResultSet rs = ps.executeQuery();)
			{
				while(rs.next())
				{
					Employee emp = new Employee();
					emp.setEmpno(rs.getInt(1));
					emp.setEname(rs.getString(2));
					emp.setJob(rs.getString(3));
					emp.setSalary(rs.getFloat(4));
					emp.setDeptno(rs.getInt(5));
					
					list.add(emp);
					
				}
			}
			
		}
		catch(SQLException se)
		{
			se.printStackTrace();
			throw se;
		}
		catch(Exception e)
		{
			e.printStackTrace();
			throw e;
		}
		return list;
	}

}
