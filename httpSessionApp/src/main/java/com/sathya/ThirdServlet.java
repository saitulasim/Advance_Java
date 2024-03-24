package com.sathya;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/ThirdServlet")
public class ThirdServlet extends HttpServlet {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email =request.getParameter("email");
		int mobile =Integer.parseInt(request.getParameter("mobile"));
		HttpSession session=request.getSession(false);
		PrintWriter writer=response.getWriter();
		response.setContentType("text/html");
		writer.println("<html>");

		writer.println("<body bgcolor='pink'>");
		writer.println("<pre>");
		writer.println("username:"+session.getAttribute("username"));
		
		writer.println("user age:"+session.getAttribute("age"));
		writer.println("user qualification:"+session.getAttribute("qualification"));
		writer.println("user designation:"+session.getAttribute("designation"));
		writer.println("user email:"+ session.getAttribute("email"));
		writer.println("user mobile:"+session.getAttribute("mobile"));
		writer.println("</pre>");
		writer.println("</body>");
		writer.println("</html>");

		
	}

}
