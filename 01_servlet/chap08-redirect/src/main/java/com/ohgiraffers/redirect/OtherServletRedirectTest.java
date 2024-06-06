package com.ohgiraffers.redirect;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/otherservlet")
public class OtherServletRedirectTest extends HttpServlet {
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 객체를 공유하지 않기 때문에 새로고침을 해도 콘솔에 계속 찍히지 않음
		System.out.println("Get 요청 정상 수락");
		
		response.sendRedirect("redirect");
		
		//redirect를 할때도 정보를 보내고 싶어서 사용하는 방법이 쿠키와 세션이다.
		
		
	}

}
