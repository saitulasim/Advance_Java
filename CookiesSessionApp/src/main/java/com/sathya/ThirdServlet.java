package com.sathya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {

		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			Cookie[] cookies= request.getCookies();
	
		response.setContentType("text/html");
		PrintWriter writer=response.getWriter();
		writer.println("<html>");

		writer.println("<body bgcolor='red'>");
		writer.println("<pre>");
		writer.println("username:"+cookies[0].getValue());
		
		writer.println("user age:"+cookies[1].getValue());
		writer.println("user qualification:"+cookies[2].getValue());
		writer.println("user designation:"+cookies[3].getValue());
		writer.println("user email:"+ cookies[4].getValue());
		writer.println("user mobile:"+cookies[5].getValue());
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");

		
	}

}
