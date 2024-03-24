package com.sathya;

import java.util.List;

public class DBclient {

	public static void main(String[] args) {
	
	       ProductDao productDao=new ProductDao();
			
	       
		//table creation
	       productDao.createproductTable();
	       System.out.println("Table created successfully");
			
			//save method calling
			int res1=productDao.save(new Product(1001,"AC",10000));
			System.out.println("data inserted successfully"+res1);
			int res2=productDao.save(new Product(1002,"Oven",20000));
			System.out.println("data inserted successfully"+res2);
	       
	       //get product by id
	       Product p=productDao.getProductById(1001);
	       System.out.println(p);
	       
	       //get all products
	       List<Product> pro=productDao.getAllProducts();
	       pro.forEach(prod->System.out.println(prod));
	       
	       
	       //updateprice
	       int res=productDao.updateByPrice(500, 9000);
	       System.out.println(res+" rows updated");
	       
	       //delete record
	       int res11=productDao.deleteById(1002);
	       System.out.println(res11+" rows deleted");
	       
	       //delete record by salary
	       int res21=productDao.deleteByPrice(20000);
	       System.out.println(res21+"rows deleted");
	       
	       //droptable
	       productDao.dropTable();
	       System.out.println("Table Dropped");
			
			
			
			
			
		}

	}
	
