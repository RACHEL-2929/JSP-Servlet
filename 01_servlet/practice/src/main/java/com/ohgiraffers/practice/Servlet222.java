package com.ohgiraffers.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@WebServlet("/priceforward")
public class Servlet222 extends HttpServlet {

	/*protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pro_name = request.getParameter("pro_name");
		int pro_count = Integer.valueOf(request.getParameter("pro_count"));
		int price = (int) request.getAttribute("price");
		
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		out.println("<!doctype html>");
		out.println("<html>");
		out.println("<head>");
		out.println("</head>");
		out.println("<body>");
		out.println("<h3>");
		out.println(pro_name +" 제품 " + pro_count + "개는 " + pro_count*price + "원 입니다.");
		out.println("</h3>");

		out.println("<a href=\"cookiesession\">쿠키와 세션을 이용한 redirect</a>");
		out.println("</body>");
		out.println("</html>");
		
		out.close();
	
	*/
//	}

}
