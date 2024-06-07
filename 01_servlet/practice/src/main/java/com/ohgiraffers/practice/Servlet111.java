package com.ohgiraffers.practice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/price")
public class Servlet111 extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pro_name = request.getParameter("pro_name");
		int pro_count = Integer.valueOf(request.getParameter("pro_count"));
		int price = 0;
		
		if (pro_count>0) {
			if ("의자".equals(pro_name)) {
				price = 90000;
			} else if("책상".equals(pro_name)) {
				price = 100000;
			}else if("침대".equals(pro_name)){
				price = 1200000;
			}
		}
		
		
		
		request.setAttribute("price", price);
		
		RequestDispatcher rd = request.getRequestDispatcher("priceforward");
		rd.forward(request, response);

	}

}
