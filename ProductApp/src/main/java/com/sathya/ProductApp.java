package com.sathya;

import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.io.IOUtils;

@WebServlet("/ProductApp")
@MultipartConfig
public class ProductApp extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Read the data
		String proId=request.getParameter("proId");
		String proName=request.getParameter("proName");
		Double proPrice=Double.parseDouble(request.getParameter("proPrice"));
		String proBrand=request.getParameter("proBrand");
		String proMadeIn=request.getParameter("proMadeIn");
		Date proMfgDate=Date.valueOf(request.getParameter("proMfgDate"));
		Date proExpDate=Date.valueOf(request.getParameter("proExpDate"));
		Part part=request.getPart("proImage");
		InputStream inputStream=part.getInputStream();
		
		//conversion of InputStream into byte[]
		byte[] proImage = IOUtils.toByteArray(inputStream);
		
		//before method using input stream
//		Part part=request.getPart("proImage");
//		InputStream proImage=part.getInputStream();
		
		//Using above details create the product object
		
		Product product=new Product();
		product.setProId(proId);
		product.setProName(proName);
		product.setProPrice(proPrice);
		product.setProBrand(proBrand);
		product.setProMadeIn(proMadeIn);
		product.setProMfgDate(proMfgDate);
		product.setProExpDate(proExpDate);
		product.setProImage(proImage);
		
		//Giving the product object to DAO layer
		ProductDao productDao=new ProductDao();
		int result=productDao.save(product);
		if(result==1)
		{
			request.setAttribute("saveResult",result);
			RequestDispatcher dispatcher = request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
		}
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("Inserted Data failed..."+result);
		RequestDispatcher dispatcher = request.getRequestDispatcher("add-product.html");
		dispatcher.include(request, response);
	}

}
