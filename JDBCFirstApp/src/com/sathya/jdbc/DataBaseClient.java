package com.sathya.jdbc;

public class DataBaseClient {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
EmployeeDao employeeDao=new EmployeeDao();
int res1 = employeeDao.save(new Employee(1001,"sai",40000));

System.out.println("Data inserted successfully.."+res1);
int res2 = employeeDao.save(new Employee(1003, "tinku", 50000));

System.out.println("Data inserted successfully.."+res2);
//read the data from database
Employee employee=employeeDao.findById(1001);
System.out.println(employee);
Employee employee1=employeeDao.findById(1003);
System.out.println(employee1);
int delCount=employeeDao.deleteById(1001);
if(delCount==1)
System.out.println("Data deleted successfully");	
else
	System.out.println("data delete fail");  
 int delCount1=employeeDao.deleteBySalary(40000);
System.out.println(delCount1+" records are deleted.."); 
}

}
