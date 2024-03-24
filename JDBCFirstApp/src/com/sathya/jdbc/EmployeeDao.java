package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDao {
public int save(Employee emp) 
{
	Connection connection=null;
	PreparedStatement preparedStatement=null;
	int count=0;
	try
	{
		connection = DbConnection.createConnection();
		preparedStatement= connection.prepareStatement("insert into emp values(?,?,?)");
		preparedStatement.setInt(1, emp.getEmpId());
		preparedStatement.setString(2, emp.getEmpName());
		preparedStatement.setDouble(3, emp.getEmpSalary());
count=preparedStatement.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	finally
	{
		try
		{
		if(connection!=null)
				connection.close();
			
		if(preparedStatement!=null)
			preparedStatement.close();
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
				
	}
				return count;
				
	}
public Employee findById(int empId)
{
	Employee employee=null;
	try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("select * from emp where id=?"))
{
	preparedStatement.setInt(1, empId);
	ResultSet resultSet = preparedStatement.executeQuery();
	if(resultSet.next())
	{
		employee = new Employee();
		employee.setEmpId(resultSet.getInt(1));
		employee.setEmpName(resultSet.getString(2));
		employee.setEmpSalary(resultSet.getDouble(3));
	}
}
catch(SQLException e)
{
	e.printStackTrace();
}
return employee;

}
 public int deleteById(int empId)

{
	int count=0;
	try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where id=?"))
	{
		preparedStatement.setInt(1, empId);
		count= preparedStatement.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}

	return count; 
	}
 public int deleteBySalary(double empSalary)
{
	int count =0;
	try(Connection connection=DbConnection.createConnection();
			PreparedStatement preparedStatement=connection.prepareStatement("delete from emp where Salary>?"))
	{
		preparedStatement.setDouble(1, empSalary);
		count=preparedStatement.executeUpdate();
	}
	catch(SQLException e)
	{
		e.printStackTrace();
	}
	return count;
}
}  

