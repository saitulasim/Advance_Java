package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class FullName extends HttpServlet {
	
  	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  		String FirstName= request.getParameter("FirstName");
		String MiddleName= request.getParameter("MiddleName");
		String LastName= request.getParameter("LastName");
		String status;
			status=FirstName+" "+MiddleName+" "+LastName;
		
		
		PrintWriter writer= response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");
		writer.println("<h1> FullName is...</h1>"+status);
		writer.println("</html>");

  	}

}
