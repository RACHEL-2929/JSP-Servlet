package com.ohgiraffers.listener.section01.context;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/context")
public class ContextListenerTestServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("context listener 확인용 servlet");
		
		ServletContext context = request.getServletContext();
		
		context.setAttribute("test", "value");//Context attribute 추가
		
		context.setAttribute("test", "value2");//Context attribute 수정
		
		context.removeAttribute("test");//Context attribute 삭제
		
	}

}
