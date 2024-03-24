package com.sathya.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/sai")
public class HelloWorldServlet extends HttpServlet {
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			PrintWriter writer= response.getWriter();
//			response.setContentType("text/plain");
			writer.println("<html>");
			writer.println("<h1>INDU IS GOOD GIRL</h1>");
			writer.println("</html>");
	
	}

}
