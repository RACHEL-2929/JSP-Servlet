package com.ohgiraffers.json.section02;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/receive/array")
public class ReceiveArrayStringServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.print("[{\"type\":\"get\",\"firstname\":\"squirrel\",\"lastname\": \"nam\",\"height\":200},");
		out.print("{\"type\":\"get\",\"firstname\":\"pig\",\"lastname\": \"jung\",\"height\":300},");
		out.print("{\"type\":\"get\",\"firstname\":\"tiger\",\"lastname\": \"kim\",\"height\":500},");
		out.print("{\"type\":\"get\",\"firstname\":\"sheep\",\"lastname\": \"woo\",\"height\":170}]");
		out.close();
	
	
	}

}
