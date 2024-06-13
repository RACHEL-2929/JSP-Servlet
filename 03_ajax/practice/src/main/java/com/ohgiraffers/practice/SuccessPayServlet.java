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
		int discont = Integer.valueOf(request.getParameter("discount"));
		double discountPrice = 0;
		
//		최종결제 금액 출력
		discountPrice = (1-0.01*discont) * price;
		
		JSONObject json = new JSONObject();
		json.put("discountPrice", discountPrice);
		
		response.setContentType("application/json; charset=UTF-8");

		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	
	}

}
