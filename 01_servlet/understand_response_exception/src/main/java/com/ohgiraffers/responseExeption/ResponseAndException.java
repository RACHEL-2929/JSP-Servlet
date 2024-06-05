package com.ohgiraffers.responseExeption;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

@WebServlet("/response")
public class ResponseAndException extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String furnitureName = request.getParameter("name");
		int count = Integer.valueOf(request.getParameter("count"));
		
		int total;
		if(furnitureName.equals("chair")) {
			total = count * 90000;
		}else if (furnitureName.equals("bed")) {
			total = count * 1000000;
		}else {
			total = count * 80000;
		}
		

		if(count<0) {
			response.sendError(404, "수량은 음수일 수 없습니다.");
			
		}else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			
			out.print("<h1>총 가격은 " + total + "입니다.</h1>");
			out.close();
		}
		
	
		
	
	}
	
}
