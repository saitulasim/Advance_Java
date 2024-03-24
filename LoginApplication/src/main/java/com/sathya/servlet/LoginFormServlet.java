package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/LoginServlet")
public class LoginFormServlet extends HttpServlet {
	
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String Username= request.getParameter("Username");
			String Password= request.getParameter("Password");
			String status;
			if(Username.equals("sathya")&& (Password.equals("sathya123")))
					{
				status="Login Succefull";
					}
			else
			{
				status="Login Failed";
			}
			PrintWriter writer= response.getWriter();
			response.setContentType("text/html");
			writer.println("<html>");
			writer.println("<h1> Login Status...</h1>"+status);
			writer.println("</html>");
			
}
}