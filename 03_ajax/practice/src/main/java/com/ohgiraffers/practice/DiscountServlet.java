package com.ohgiraffers.practice;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/discount")
public class DiscountServlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//임의로 카드에 따른 할인율로 계산한 뒤 완료 페이지 반환
		//우리, 국민, 카카오
		//card_name에 대한 value, card_number
		
		String card_name = request.getParameter("card_name");
		String card_number = request.getParameter("card_number");
		String pro_name = request.getParameter("pro_name");
		int pro_count =Integer.parseInt(request.getParameter("pro_count")) ;
		int pro_price =Integer.parseInt(request.getParameter("pro_price")) ;
		int pro_total =Integer.parseInt(request.getParameter("pro_total")) ;

		double discount = 0;
		
		  switch (card_name) { 
		  case "woori":
			  card_name = "우리";
			  discount = 0.08;
			  break; 
		  case "kb": 
			  card_name = "국민";
			  discount = 0.1;
			  break;
		  case "kakao":
			  card_name = "카카오";
			  discount = 0.05;
			  break;
		default: discount=0.01;
		  }
		  
		  request.setAttribute("card_name", card_name);
		  request.setAttribute("card_number", card_number);
		  request.setAttribute("pro_name", pro_name);
		  request.setAttribute("pro_count", pro_count);
		  request.setAttribute("pro_price", pro_price);
		  request.setAttribute("pro_total", pro_total);
		  request.setAttribute("discount", discount);
		  
		  
		 RequestDispatcher rd = request.getRequestDispatcher("views/complete.jsp");
		 rd.forward(request, response);
		
		
		
	}

}
