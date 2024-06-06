package com.ohgiraffers.session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/session")
public class SessionHandlerServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		
		System.out.println(firstName + lastName);
		
		
		HttpSession session = request.getSession();
		// 1800초
		System.out.println("session 유지 시간 default : " + session.getMaxInactiveInterval());
		// 시간 바꾸는 방법 우선순위 1
		session.setMaxInactiveInterval(60*10);
		// 시간 바꾸는 방법 우선순위 2 web.xml에서 timeout 태그로 가능
		// 시간 바꾸는 방법 우선순위 3 톰캣 conf 안에 있는 web.xml에서도 timeout 태그로 가능
		
		
		System.out.println("sesssion id : " + session.getId());
		
		session.setAttribute("firstName",firstName);
		session.setAttribute("lastName",lastName);
		
		
		response.sendRedirect("redirect");
	
	}

}
