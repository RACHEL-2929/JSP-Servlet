package com.ohgiraffers.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONObject;

@WebServlet("/success")
public class SuccessPayServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cardName = request.getParameter("card_name");
		int price = Integer.valueOf(request.getParameter("price"));
		double discountPrice = 0;
		
		if ("woori".equals(cardName)) {
//			8%
			discountPrice = 0.92 * price;
		} else if("kb".equals(cardName)) {
//			10%
			discountPrice = 0.9*price;
		}else if("kakao".equals(cardName)){
//			5%
			discountPrice = 0.95*price;
		}
		
		JSONObject json = new JSONObject();
		json.put("discountPrice", discountPrice);
		
		response.setContentType("application/json; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	
	}

}
