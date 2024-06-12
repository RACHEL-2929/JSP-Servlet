package com.ohgiraffers.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

@WebServlet("/cardiscount")
public class CardDiscountServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardName = request.getParameter("card_name");
		int discount = 0;
		
		
		if ("woori".equals(cardName)) {
//			8%
			discount = 8;
		} else if("kb".equals(cardName)) {
//			10%
			discount = 10;
		}else if("kakao".equals(cardName)){
//			5%
			discount = 5;
		}
		
		JSONObject json = new JSONObject();
		json.put("discount", discount);
		
		response.setContentType("application/json; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	
	}

}
