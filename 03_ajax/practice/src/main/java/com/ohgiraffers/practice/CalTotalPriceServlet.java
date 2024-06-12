package com.ohgiraffers.practice;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.ohgiraffers.practice.product.ProductDTO;

@WebServlet("/totalprice")
public class CalTotalPriceServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		int count = Integer.valueOf(request.getParameter("pro_count"));
		String name = request.getParameter("pro_name");
		int price = 0;
		
		if (count>0) {
			if ("chair".equals(name)) {
				price = 90000*count;
			} else if("desk".equals(name)) {
				price = 100000*count;
			}else if("bed".equals(name)){
				price = 1200000*count;
			}
		}
		
		
		JSONObject json = new JSONObject();
		json.put("price",price);
		
		
		
		response.setContentType("application/json; charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.print(json);
		out.close();
	}

}
