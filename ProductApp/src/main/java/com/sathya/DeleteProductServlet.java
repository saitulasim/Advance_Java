package com.sathya;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/DeleteProductServlet")
public class DeleteProductServlet extends HttpServlet {
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			String ProId = request.getParameter("proId");
			ProductDao productDao=new ProductDao();
			int result = productDao.deleteById(ProId);
			if(result==1)
			{	
				request.setAttribute("deleteResult",result);
				RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
				dispatcher.forward(request, response);
				
			}
			else
			{
				
			request.setAttribute("deleteResult",result);

			RequestDispatcher dispatcher=request.getRequestDispatcher("productList.jsp");
			dispatcher.forward(request, response);
			}
			
		}

}
