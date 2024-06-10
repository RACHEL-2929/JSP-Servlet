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
		int pro_price = 0;
		
		
		if (pro_count>0) {
			if ("chair".equals(pro_name)) {
				pro_price = 90000;
				pro_name = "의자";
			} else if("desk".equals(pro_name)) {
				pro_price = 100000;
				pro_name = "책상";
			}else if("bed".equals(pro_name)){
				pro_price = 1200000;
				pro_name = "침대";
			}
		}
		
		
		
		request.setAttribute("pro_price", pro_price);
		request.setAttribute("pro_name", pro_name);
		request.setAttribute("pro_count", pro_count);
		
		RequestDispatcher rd = request.getRequestDispatcher("views/priceForward.jsp");
		rd.forward(request, response);

	}

}
