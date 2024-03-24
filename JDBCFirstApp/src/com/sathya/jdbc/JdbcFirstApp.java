package com.sathya.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcFirstApp {

	public static void main(String[] args)  throws ClassNotFoundException, SQLException
	{
		// TODO Auto-generated method stub

	Class.forName("oracle.jdbc.driver.OracleDriver");
	System.out.println("Driver Loaded Succefully.....");
	Connection connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "saitulasi", "saitulasi");
	 System.out.println("Connection created successfully");
	 Statement statement = connection.createStatement();
	 String q1= "create table emp(id number,name varchar2(20),salary number)";
	 int res1= statement.executeUpdate(q1);
	 System.out.println("Table created Successfully"+ res1);
	// String q2 ="drop table emp";
	// int res2 = statement.executeUpdate(q2);
	// System.out.println("Table Dropped successfully.."+res2);
	 connection.close();
	 System.out.println("Connection closed Succesfully");
}
}
