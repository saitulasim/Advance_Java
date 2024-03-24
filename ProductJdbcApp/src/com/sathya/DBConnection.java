package com.sathya;

import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
public static Connection createConnection()
{
	Connection connection=null;
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		connection = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "saitulasi", "saitulasi");

	}
	catch(ClassNotFoundException | SQLException e)
	{
		e.printStackTrace();
	}
	return connection;
	}
public static void closeConnection(Connection connection) {
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace(); // Consider logging the exception instead
        }
}}}

