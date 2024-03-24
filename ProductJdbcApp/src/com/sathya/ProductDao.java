package com.sathya;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductDao {
	//create table
		 public void createTable() {
			 Connection connection=null;
			 PreparedStatement preparedStatement=null;
			 try{
				 connection =DBConnection.createConnection(); 
			 preparedStatement=connection.prepareStatement("create table product (proId number,proName varchar2(20),proPrice number)");
				preparedStatement.executeUpdate();
			 } 
			 catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
		//save method
		  public int save(Product pro) {
			//Declare the Resources
			Connection connection=null;
			PreparedStatement preparedStatement=null;
			int count=0;
			try {
				//Get the connection
				 connection= DBConnection.createConnection();
				//Create the PS object
				preparedStatement=connection.prepareStatement("insert into product values(?,?,?)");
				//Read the data from pro object and set to parameters
				preparedStatement.setInt(1, pro.getProId());
				preparedStatement.setString(2, pro.getProName());
				preparedStatement.setDouble(3, pro.getProPrice());
				count=preparedStatement.executeUpdate();
				
			}
			catch(SQLException e) {
				e.printStackTrace();
			}
			finally
			{
				//Before release connection check the connection present or not
				try{
					if(connection!=null)
				      connection.close();
				    if(preparedStatement!=null)
					  preparedStatement.close();
				}
				catch(SQLException e) {
				     e.printStackTrace();
			}
			
		   }
			return count;
	}
		//getProductById  method 
			public Product getProductById(int proId) 
			{
				Product product=null;
				
				
				try (Connection connection=DBConnection.createConnection(); PreparedStatement preparedStatement=connection.prepareStatement("select * from product where proId=?")){ 
					preparedStatement.setInt(1, proId);
					ResultSet resultSet=preparedStatement.executeQuery();
					if(resultSet.next())
					{
			            product=new Product();
						product.setProId(resultSet.getInt(1));
						product.setProName(resultSet.getString(2));
						product.setProPrice(resultSet.getDouble(3));
					}
					
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
			return product;	
			}
			
			
			
			//allProducts
			public List<Product> getAllProducts(){
				List<Product> pro=new ArrayList<Product>();
				try(Connection connection=DBConnection.createConnection(); Statement statement=connection.createStatement()){
					ResultSet resultSet=statement.executeQuery("select * from product");
					while(resultSet.next()) {
						Product product=new Product();
						product.setProId(resultSet.getInt(1));
						product.setProName(resultSet.getString(2));
						product.setProPrice(resultSet.getDouble(3));
						pro.add(product);
					}
					
					
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return pro ;	
				
			}
			
			//updatebyprice
			public int updateByPrice(int priceRange, int incrementPrice) {
				int count=0;
				try (Connection connection=DBConnection.createConnection(); PreparedStatement preparedStatement=connection.prepareStatement("update product set proPrice=proPrice+? where proPrice>?")){ 
					preparedStatement.setInt(1, incrementPrice);
					preparedStatement.setInt(2, priceRange);
					count=preparedStatement.executeUpdate();
				}
				catch(SQLException e)
				{
					e.printStackTrace();
			    }
				return count;
			}
			
			
			//delete record using ID
			public int deleteById(int proId) {
				int count=0;
				try (Connection connection=DBConnection.createConnection(); PreparedStatement preparedStatement=connection.prepareStatement("delete product where proId=?")){ 
					preparedStatement.setInt(1, proId);
					count=preparedStatement.executeUpdate();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				return count;
			}
			
			
			//delete record by price
			public int deleteByPrice(double proPrice) {
				int count=0;
				try (Connection connection=DBConnection.createConnection(); PreparedStatement    preparedStatement=connection.prepareStatement("delete product where proPrice>?")){ 
					preparedStatement.setDouble(1, proPrice);
					count=preparedStatement.executeUpdate();
				}
				catch(SQLException e) {
					e.printStackTrace();
				}
				return count;
			}
			
			//drop table
			public void dropTable() {
				try(Connection connection=DBConnection.createConnection(); Statement statement=connection.createStatement()){
					statement.executeUpdate("drop table product");
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();

}
			}
}
